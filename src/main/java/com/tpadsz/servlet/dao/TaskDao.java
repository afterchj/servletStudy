package com.tpadsz.servlet.dao;

import com.tpadsz.servlet.entity.MaoTask;

import java.util.List;

/**
 * Created by hongjian.chen on 2017/9/29.
 */
public interface TaskDao {
    void batchInsert(List<MaoTask> list);
    void addOne(MaoTask task);
}
