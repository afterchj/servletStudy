package com.tpadsz.servlet.dao;

import com.tpadsz.servlet.entity.MaoTask;

import java.util.Date;
import java.util.List;

/**
 * Created by hongjian.chen on 2017/9/29.
 */
public interface TaskDao {
    void batchInsert(List<MaoTask> list) throws Exception;
    void batchUpdate(List<MaoTask> list) throws Exception;
    int getCount();
    Date getDate();
    void addOne(MaoTask task);
    void updateOne(MaoTask task);
    void insertBatch(List<MaoTask> list);
    void updateBatch(List<MaoTask> list);
}
