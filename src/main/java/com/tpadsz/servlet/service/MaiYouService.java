package com.tpadsz.servlet.service;

import com.tpadsz.servlet.entity.DMaiyouApp;
import com.tpadsz.servlet.entity.DMaiyouPrizeStep;
import com.tpadsz.servlet.entity.Params;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hongjian.chen on 2017/11/21.
 */
public interface MaiYouService {
    DMaiyouApp findMaiyouApp(@Param("id") String id);


    List<DMaiyouPrizeStep> findPrizeStep(Params params);

    String findPrizeStepByUid(Params params);

    String findGetCoinsTypeByUser(@Param("dataId") String dataId, @Param("account") String account);
}
