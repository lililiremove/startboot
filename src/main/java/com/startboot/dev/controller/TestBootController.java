package com.startboot.dev.controller;

import com.startboot.dev.pojo.Vo.ResultVo;
import com.startboot.dev.pojo.entity.User;
import com.startboot.dev.service.UserService;
import com.startboot.dev.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/testBoot")
public class TestBootController {

    @Autowired
    private UserService userService;

//    @PostMapping(value = "/addUser")
//    public ResultVo addUser(){
//        int i = userService.addUser();
//        if (i>0){
//            return ResultUtil.success();
//        }else{
//            throw new StartBootException(400,"插入失败");
//        }
//    }

    @GetMapping(value = "/getUserAll")
    public Object getUserAll(){
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
        List<User> userAll = userService.getUserList();
        return ResultUtil.success(userAll);
    }


}
