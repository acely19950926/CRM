package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //标注持久层
public class UserDaoImpl implements UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(User user) {
        hibernateTemplate.save(user);
    }

    @Override
    public User findUserByNameAndPwd(String userCode, String userPassword) {
        System.out.println("aaaa");
        List<User> userList = (List<User>) hibernateTemplate.find("from User where userCode = ? AND userPassword = ?", userCode, userPassword);
        if (userList != null && userList.size() > 0) {
            System.out.println(userList.get(0));
            return userList.get(0);
        }
        return null;
    }

    @Override
    public void update(User user) {
        hibernateTemplate.update(user);
    }
}
