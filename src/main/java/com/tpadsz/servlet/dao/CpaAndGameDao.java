package com.tpadsz.servlet.dao;



import com.tpadsz.servlet.entity.CpaAndGameLog;

import java.util.List;
import java.util.Map;

/**
 * Created by hongjian.chen on 2017/12/18.
 */
public interface CpaAndGameDao {

    void insertLogs(List<CpaAndGameLog> list);

    void updateLog(CpaAndGameLog log);

    void insertLog(CpaAndGameLog log);

    List<CpaAndGameLog> getLogInfo(Map map);
    List<CpaAndGameLog> getNewUser(Map map);
    List<CpaAndGameLog> getTotalUser(Map map);
    List<CpaAndGameLog> getLogData(Map map);
    List<CpaAndGameLog> getDataInfo(Map map);
}
