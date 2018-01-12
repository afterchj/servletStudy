package com.tpadsz.servlet.test;

import com.tpadsz.servlet.dao.MaiyouDao;
import com.tpadsz.servlet.entity.DMaiyouPrizeStep;
import com.tpadsz.servlet.entity.Params;
import com.tpadsz.servlet.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by hongjian.chen on 2017/11/21.
 */
public class MaiYouDemo {
    SqlSession session = MybatisUtil.getSession();

    @Test
    public void findMaiyouPrize() {
        Params params = new Params();
        params.setDataId("12345");
        params.setType("1");
        params.setUid("b7d985b053974d788b6b97439615b4b5");
        params.setPage(0);
        String info = session.getMapper(MaiyouDao.class).findPrizeStepByUid(params);
        System.out.println(info);
        String[] type = info.split(",");
        for (int i = 0; i < type.length; i++) {
            String isGet = "0";
            System.out.println("type=" + type[i]);
            String[] step = type[i].split("_");
            for (int j = 0; j < step.length; j++) {
                System.out.println("stepNum=" + step[j]);
                isGet = "1";
            }
            System.out.println(isGet);
        }
    }

    @Test
    public void findMaiyouPrizeStep() {
        String isGet = "0";
        Params params = new Params();
        params.setDataId("12345");
        params.setType("2");
        params.setUid("b7d985b053974d788b6b97439615b4b5");
        params.setPage(0);
        List<DMaiyouPrizeStep> prizeSteps = session.getMapper(MaiyouDao.class).findPrizeStep(params);
        String info = session.getMapper(MaiyouDao.class).findPrizeStepByUid(params);
        System.out.println(info);
        for (int i = 0; i < prizeSteps.size(); i++) {
            String isGetCoinsType = "" + prizeSteps.get(i).getType() + "" + "_" + "" + prizeSteps.get(i).getStepNum() + "";
            if (info.contains(isGetCoinsType)) {
                isGet = "1";
            } else {
                isGet = "0";
            }
            System.out.println(isGetCoinsType + "     " + prizeSteps.get(i).getStepNum() + "     " + isGet);
        }
    }
}
