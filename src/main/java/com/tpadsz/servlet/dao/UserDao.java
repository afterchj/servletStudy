package com.tpadsz.servlet.dao;

import com.tpadsz.servlet.entity.User;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserDao {
    User selectUserByID(int var1);

    List<User> selectAll();

    void addUser(User var1);

    void updateUser(User var1);

    void update(User var1);

    void deleteUser(int var1);

    void save(Map map) throws SQLException;

    List<Map> getValues(String loginName);

    Integer getLuck(String loginName);

    Date getDate(String loginName);

    void batchUpdate(List<User> list);
}