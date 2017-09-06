package com.tpadsz.servlet.service;

import com.tpadsz.servlet.entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public UserService() {
    }

    public List<User> getAll() {
        ArrayList list = new ArrayList();

        for(int i = 0; i < 3; ++i) {
            User user = new User();
            user.setId(i);
            user.setName("test" + i);
            user.setPwd("12" + i);
            list.add(user);
        }

        return list;
    }

    public User getById(int id) {
        List users = this.getAll();
        User user = new User();

        for(int i = 0; i < users.size(); ++i) {
            int id0 = ((User)users.get(i)).getId();
            System.out.println("id=" + ((User)users.get(i)).getId() + ",name=" + ((User)users.get(i)).getName());
            if(id0 == id) {
                user = (User)users.get(i);
            }
        }

        return user;
    }

    public void update(User user) {
    }

    public int deleteOne(int id) {
        List users = this.getAll();
        byte result = 0;

        for(int i = 0; i < users.size(); ++i) {
            if(((User)users.get(i)).getId() == id) {
                users.remove(i);
                result = 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        UserService service = new UserService();
        User user = service.getById(1);
        System.out.println("id=" + user.getId() + ",name=" + user.getName());
    }
}
