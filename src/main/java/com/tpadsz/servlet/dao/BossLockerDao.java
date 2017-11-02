package com.tpadsz.servlet.dao;

import com.tpadsz.servlet.entity.BossLocker;

/**
 * Created by hongjian.chen on 2017/10/31.
 */
public interface BossLockerDao {
    void saveOrUpdate(BossLocker locker);
    String getStatus(String uid);
    void save(BossLocker locker);
}
