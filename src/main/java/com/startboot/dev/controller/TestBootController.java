package com.startboot.dev.controller;

import com.startboot.dev.pojo.User;
import com.startboot.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/testBoot")
public class TestBootController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser")
    @ResponseBody
    public String addUser(){
        String flag=null;
        int i = userService.addUser();
        if (i>0){
            return flag="插入成功";
        }
        return flag;
    }

    @RequestMapping(value = "/getUserAll")
    @ResponseBody
    public Object getUserAll(){
        String flag=null;
        List<User> userAll = userService.getUserAll();
        if (userAll.size()>0){
            return userAll;
        }
        return "0";
    }

}
