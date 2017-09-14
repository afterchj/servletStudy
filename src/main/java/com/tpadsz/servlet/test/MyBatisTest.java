package com.tpadsz.servlet.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tpadsz.servlet.dao.UserDao;
import com.tpadsz.servlet.entity.User;
import com.tpadsz.servlet.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hongjian.chen on 2017/6/7.
 */
public class MyBatisTest {
    SqlSession session = MybatisUtil.getSession();

    public void update() {
    }

    @Test
    public void test() {
        List users = session.selectList("selectAll");
        session.selectList("selectAll");
        System.out.println("id\tname\tpwd");
        Iterator list = users.iterator();

        while (list.hasNext()) {
            User u = (User) list.next();
            System.out.println(u.getId() + "\t" + u.getName() + "\t" + u.getPwd());
        }

    }

    @Test
    public void getAll() {
        List list = session.getMapper(UserDao.class).selectAll();
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入id:");
        int id = sc.nextInt();
        user.setId(id);
        System.out.println("请输入name:");
        String name = sc.next();
        user.setName(name);
        System.out.println("请输入pwd:");
        String pwd = sc.next();
        user.setPwd(pwd);
        SqlSession session = MybatisUtil.getSession();
        ((UserDao) session.getMapper(UserDao.class)).updateUser(user);
        session.commit();
        User user1 = ((UserDao) session.getMapper(UserDao.class)).selectUserByID(101);
        System.out.print(user1.getName());
    }

    @Test
    public void getValues() {
        SimpleDateFormat format = new SimpleDateFormat();
        List<Map> list = session.getMapper(UserDao.class).getValues("7344614");
        Map map = list.get(0);
        System.out.println(map.size());
        Date date = (Date) map.get("createDate");
        System.out.println(date);
        Integer luckValues = (Integer) map.get("luckValues");
        System.out.println("createDate=" + map.get("createDate") + ",luckValues=" + luckValues);
//        session.commit();
    }

    @Test
    public void saveLuck() {
        String str = "{\"myself\":\"7344614\",\"friends\":\"7344614\"}";
        JSONObject params = JSON.parseObject(str);
        Map<String, Object> map = JSONObject.toJavaObject(params, Map.class);
        if (map.get("myself").equals(map.get("friends"))) {
            System.out.println("不能给自己打气");
        }
        try {
            session.getMapper(UserDao.class).save(map);
            session.commit();
        } catch (Exception e) {
            System.out.println("不能重复给好友打气");
            return;
        }
    }

    @Test
    public void getLuck() {
        Integer luck = session.getMapper(UserDao.class).getLuck("12301");
        Date date = session.getMapper(UserDao.class).getDate("12301");
        System.out.println("createDate=" + date + ",luckValues=" + luck);
    }

    @Test
    public void add() {
        User user = new User();
        user.setId(2);
        user.setName("after");
        user.setPwd("after");
        session.getMapper(UserDao.class).update(user);
        session.commit();
    }

    @Test
    public void save() {
        Map map = new HashMap();
        map.put("myself", "123");
        map.put("friends", "12301");
        try {
            session.getMapper(UserDao.class).save(map);
            session.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void batchUpdate() {
        List<User> list = new ArrayList<User>();
        for (int i = 102; i < 105; i++) {
            User user = new User();
            user.setId(i);
            user.setName("test" + i);
            user.setPwd("a" + i);
            list.add(user);
            session.getMapper(UserDao.class).addUser(user);
            session.commit();
        }
//        for (User user : list) {
//            System.out.println(user.getId() + "," + user.getName() + "," + user.getPwd());
//        }
//        User user = new User();
//        user.setId(104);
//        user.setName("admin");
//        user.setPwd("admin123");
//        list.add(user);
//        (this.session.getMapper(UserDao.class)).batchUpdate(list);
//        this.session.commit();
    }

    @Test
    public void getBy() {
        byte id = 101;
        User u = ((UserDao) this.session.getMapper(UserDao.class)).selectUserByID(id);
        System.out.println("====》" + u.getId() + "\t" + u.getName() + "\t" + u.getPwd());
    }
}
