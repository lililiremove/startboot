package com.startboot.dev.controller.login;

import com.startboot.dev.pojo.User;
import com.startboot.dev.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @Author even
 * @Description
 * @Date Create in 13:40 2018/5/4
 * Modified By
 */
@Controller
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /** 项目首页 */
    @GetMapping(value = "/")
    public String index(){
        try{

        }catch (Exception e){
            logger.error("登陆失败："+e,e);
        }
        return "system/index";
    }

    /** 跳转至登陆 */
    @GetMapping(value = "/toLogin")
    public String toLogin(){
        return "system/login";
    }

    /** 登陆 */
    @PostMapping(value = "/login")
    public String login(User user, Model model){
        int flag=0;//非0即true
        if (user!=null){
            flag = userService.validationUser(user);
        }
        if (flag>0){
            return "menu/menu";
        }else {
            model.addAttribute("MSG","用户名或密码有误!");
            return "system/index";
        }
    }


}
