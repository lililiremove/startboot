package com.startboot.dev.service.impl;

import com.startboot.dev.common.UUIDGenerator;
import com.startboot.dev.mapper.UserMapper;
import com.startboot.dev.pojo.User;
import com.startboot.dev.repository.UserRepository;
import com.startboot.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository  userRepository;

    @Override
    public int addUser() {
        User user = new User();
        user.setUserid(UUIDGenerator.getUUID(31));
        user.setUsername("张三");
        user.setPassword("123456");
        user.setEmail("123456789@qq.com");
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> getUserAll() {
        return userMapper.selectUserAll();
    }

    @Override
    public User save() {
        User user = new User();
        user.setUserid(UUIDGenerator.getUUID(31));
        user.setUsername("张三");
        user.setPassword("123456");
        user.setEmail("123456789@qq.com");
        return userRepository.save(user);
    }

    public List<User> getUserList(){
        return userRepository.findAll();
    }


}
