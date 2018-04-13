package com.startboot.dev.controller;

import com.startboot.dev.Vo.ResultVo;
import com.startboot.dev.pojo.User;
import com.startboot.dev.service.UserService;
import com.startboot.dev.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/testBoot")
public class TestBootController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser")
    public String addUser(){
        String flag=null;
        int i = userService.addUser();
        if (i>0){
            return flag="插入成功";
        }
        return flag;
    }

    @GetMapping(value = "/getUserAll")
    public Object getUserAll(){
        String flag=null;
        List<User> userAll = userService.getUserAll();
        if (userAll.size()>0){
            return userAll;
        }
        return "0";
    }


    /**
     * 添加用户
     */
    @PostMapping("/saveUser")
    public ResultVo save(){
        User save = userService.save();
        return ResultUtil.success(save);
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @GetMapping(value = "/UserList")
    public ResultVo<User> getUserTest(){
        List<User> userAll = userService.getUserAll();
        return ResultUtil.success(userAll);
    }


}
