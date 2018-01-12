package com.tpadsz.servlet.test;

import com.tpadsz.servlet.dao.CpaAndGameDao;
import com.tpadsz.servlet.entity.CpaAndGameLog;
import com.tpadsz.servlet.utils.MybatisUtil;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hongjian.chen on 2017/12/18.
 */
public class logTest {

    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    SqlSession session = MybatisUtil.getSession();

    @Test
    public void testAll() {
        System.out.println("开始执行定时任务...");
        String[] types = {"新快速", "游戏"};
        String[] files = {"/mnt/shared/bosslockerstore_hq/cpa/cpaLog-", "/mnt/shared/bosslockerstore_hq/game/gameLog-"};
        for (int i = 0; i < types.length; i++) {
            System.out.println(types[i]);
//            insertLogs(types[i], files[i]);
            saveFile(types[i], files[i], 1);
        }
        System.out.println("结束执行定时任务...");
    }

    public void insertLogs(String type, String fileName) {
        String preFix = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
//        System.out.println(fileName+"    "+preFix);
        Map map = new HashMap();
        map.put("type", type);
        List<CpaAndGameLog> list0 = session.getMapper(CpaAndGameDao.class).getTotalUser(map);
        List<CpaAndGameLog> list1 = session.getMapper(CpaAndGameDao.class).getNewUser(map);
        List<CpaAndGameLog> list2 = session.getMapper(CpaAndGameDao.class).getLogInfo(map);
        List<CpaAndGameLog> list = new ArrayList<CpaAndGameLog>();
        for (int i = 0; i < list0.size(); i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -i);
            String suffix = preFix + format.format(calendar.getTime()) + ".xls";
            CpaAndGameLog log = new CpaAndGameLog();
            log.setTaskType(type);
            log.setDownloadUrl(suffix);
            log.setLogDate(list0.get(i).getLogDate());
            log.setTaskUser(list0.get(i).getTaskUser());
            log.setTaskTotal(list2.get(i).getTaskTotal());
            if (i < list1.size()) {
                log.setNewUser(list1.get(i).getNewUser());
            }
            log.setExpendSum(list2.get(i).getExpendSum() / 1000);
            list.add(log);
            System.out.println("logDate=" + format.format(list0.get(i).getLogDate()) + ",expendSum=" + list2.get(i).getExpendSum() / 1000);
        }
//        CpaAndGameLog log1;
//        if (type.equals("新快速")) {
//            log1 = list.get(1);
//            session.getMapper(CpaAndGameDao.class).insertLog(log1);
//            session.commit();
//        }
//        if (type.equals("游戏")) {
//            log1=list.get(0);
//            session.getMapper(CpaAndGameDao.class).insertLog(log1);
//        }
//        session.getMapper(CpaAndGameDao.class).insertLogs(list);
    }

    public void saveFile(String type, String fileName, int offSet) {
        for (int j = 1; j <= offSet; j++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -j);
            String suffix = format.format(calendar.getTime()) + ".xls";
//            System.out.println(fileName + suffix);
            Map map = new HashMap();
            map.put("type", type);
            map.put("offSet", j);
            List<CpaAndGameLog> list3 = session.getMapper(CpaAndGameDao.class).getLogData(map);
            WritableWorkbook book = null;
            try {
                book = Workbook.createWorkbook(new File(fileName + suffix));
                WritableSheet sheet = book.createSheet("test", 0);
                sheet.addCell(new Label(0, 0, "任务ID"));
                sheet.addCell(new Label(1, 0, "任务名称"));
                sheet.addCell(new Label(2, 0, "完成数量"));
                for (int i = 1; i < list3.size(); i++) {
                    sheet.addCell(new Label(0, i, list3.get(i).getDataId()));
                    sheet.addCell(new Label(1, i, list3.get(i).getDataName()));
                    sheet.addCell(new Number(2, i, list3.get(i).getTotal()));
                }
                book.write();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    book.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        String type = "新快速";
//        String type1="游戏";
        Map map = new HashMap();
        map.put("type", "新快速");
        map.put("beginTime", "2017-12-15");
        map.put("endTime", "2017-12-19");
        List<CpaAndGameLog> list = session.getMapper(CpaAndGameDao.class).getDataInfo(map);
        for (CpaAndGameLog log : list) {
            System.out.println(log.getTaskType() + "    " + log.getExpendSum());
        }
    }
}
