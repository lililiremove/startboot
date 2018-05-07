package com.startboot.dev.service;

import com.startboot.dev.pojo.entity.User;

import java.util.List;

public interface UserService {

    int addUser();

    List<User> getUserAll();

    /**
     * 测试
     * @return
     */
    User save();

    List<User> getUserList();

    int validationUser(User user);

}
