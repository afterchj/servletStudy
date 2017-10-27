package com.tpadsz.servlet.utils.mao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tpadsz.servlet.dao.TaskDao;
import com.tpadsz.servlet.entity.MaoTask;
import com.tpadsz.servlet.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hongjian.chen on 2017/10/10.
 */
public class SaveMaoTask {

    final String uri = "https://api.service.open.jianzhimao.com";
    final String key = "51fec0b6c9a40d1bf7b4bb649b473161";

    @Test
    public void getMewTasks2() throws Exception {
        int num = 1;
        SqlSession session = MybatisUtil.getSession();
        for (; ; ) {
            JSONObject params = new JSONObject();
            JSONObject object = new JSONObject();
            object.put("page_num", num);
            object.put("page_size", 100);
            String contents = JSON.toJSONString(object);
            String sign = Signature.signature(key + contents + key);
            String msg = AESEncryptor.encrypt(contents, key);
            params.put("content", msg);
            params.put("signature", sign);
            params.put("name", "getMewTasks");
            String msg1 = GetMaoTask.requePost(uri, params);
            JSONArray jsonArray = JSON.parseArray(msg1);
            System.out.println("执行时间=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "，外循环---->" + num + ",jsonArray.size=" + jsonArray.size());
            List<MaoTask> list = new ArrayList<MaoTask>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject object3 = (JSONObject) jsonArray.get(i);
                MaoTask task = new MaoTask();
                int status = getTaskDetail(object3.getString("task_id"));
                if (status == 0) {
                    task.setIsDelete(status);
                } else {
                    task.setIsDelete(1);
                }
                task.setTaskId(object3.getString("task_id"));
                task.setIcon("http://www.uichange.com/public/ctc/app/icon/null--203.png");
                task.setTaskTitle(object3.getString("task_title"));
                task.setTaskDesc(object3.getString("task_desc"));
                task.setTaskPrice(object3.getInteger("task_price"));
                task.setTaskSurplus(object3.getInteger("task_surplus"));
                task.setCreateDate(new Date(object3.getLong("task_create_time")));
                task.setUpdateDate(new Date(object3.getLong("task_update_time")));
                task.setType("maoHp");
                task.setOther("1.0");
                task.setStatus(0);
                list.add(task);
            }
            if (jsonArray.size() == 100) {
                num++;
            } else {
                return;
            }
            session.getMapper(TaskDao.class).insertBatch(list);
            session.commit();
        }
    }

    public int getTaskDetail(String taskId) throws Exception {
        JSONObject params = new JSONObject();
        JSONObject object = new JSONObject();
        object.put("task_id", taskId);
        String contents = JSON.toJSONString(object);
        String sign = Signature.signature(key + contents + key);
        String msg = AESEncryptor.encrypt(contents, key);
        params.put("content", msg);
        params.put("signature", sign);
        params.put("name", "getMewTaskDetail");
        String result = GetMaoTask.requePost(uri, params);
        JSONObject object1 = JSON.parseObject(result);
        int status = object1.getInteger("task_status");
        return status;
    }

    @Test
    public void test() throws Exception {
        int num ;
        int min ;
//        int count = session.getMapper(TaskDao.class).getCount();
        for (int count = 15795; count <= 15801; count++) {
            if (count != 0) {
                num = count / 100;
                min = count % 100;
                System.out.println("count:" + count + ",num=" + num + ",min=" + min);
            }
        }
//        System.out.println(getTaskDetail("29563"));
    }

    @Test
    public void testJob() {
        SqlSession session = MybatisUtil.getSession();
        int count = session.getMapper(TaskDao.class).getCount();
        System.out.println("size=" + count);
//        List<MaoTask> list = new ArrayList();
//        for (int i = 3828; i < 3838; i++) {
//            MaoTask task = new MaoTask();
//            task.setTaskId("" + i);
//            task.setTaskTitle("批量更新测试" + i);
//            task.setIcon("http://www.uichange.com/public/ctc/app/icon/null--203.png");
//            task.setTaskDesc("测试数据");
//            task.setTaskPrice(11);
//            task.setTaskSurplus(12);
//            task.setCreateDate(new Date());
//            task.setUpdateDate(new Date());
//            task.setOther("1.0");
//            list.add(task);
//        }
//        try {
//            session.getMapper(TaskDao.class).updateBatch(list);
//            session.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testBatch() {
        SqlSession session = MybatisUtil.getSession();
        List<MaoTask> list = new ArrayList<MaoTask>();
        for (int i = 0; i < 30; i++) {
            MaoTask task = new MaoTask();
            task.setTaskId("" + i);
            task.setIcon("http://www.uichange.com/public/ctc/app/icon/null--203.png");
            task.setTaskTitle("test" + i);
            task.setTaskDesc("测试" + i);
            task.setTaskPrice(i);
            task.setTaskSurplus(i);
            task.setCreateDate(new Date());
            task.setUpdateDate(new Date());
            task.setType("maoHp");
            task.setOther("1.0");
            task.setStatus(0);
            task.setIsDelete(1);
            list.add(task);
        }
        try {
            session.getMapper(TaskDao.class).batchInsert(list);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
