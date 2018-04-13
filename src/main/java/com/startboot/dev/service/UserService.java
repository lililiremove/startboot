package com.startboot.dev.service;

import com.startboot.dev.pojo.User;

import java.util.List;

public interface UserService {

    int addUser();

    List<User> getUserAll();
}
