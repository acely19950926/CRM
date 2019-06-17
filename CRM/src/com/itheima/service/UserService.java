package com.itheima.service;

import com.itheima.domain.User;

public interface UserService {
    void save(User user);

    User findUserByNameAndPwd(String userCode, String userPassword);

    void update(User user);
}
