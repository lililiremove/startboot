package com.startboot.dev.controller.login;

import com.jgoodies.common.base.Strings;
import com.startboot.dev.common.UUIDGenerator;
import com.startboot.dev.pojo.Vo.ResultVo;
import com.startboot.dev.pojo.entity.User;
import com.startboot.dev.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author even
 * @Description 对用户操作
 * @Date Create in 13:40 2018/5/4
 * Modified By
 */
@Controller
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    /** 注册失败码 */
    private final static int  REGEDITFIALCODE=1089;
    /** 用户名存在码 */
    private final static int  NAMEEXISTCODE=1088;

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
        int flag= 0;//非0即true
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

    /** 跳转至注册 */
    @GetMapping(value = "/toRegedit")
    public String toRegedit(){
        return "system/regedit";
    }

    /** 注册 */
    @PostMapping(value = "/regedit")
    @ResponseBody
    public Object regedit(User user,HttpServletRequest request){
        String jsonpCallback=request.getParameter("jsonpCallback");
        logger.info(user.getUsername());
        int flag=0;
        if (Strings.isNotEmpty(user.getUsername().trim())&&Strings.isNotEmpty(user.getPassword().trim())){
            user.setUserid(UUIDGenerator.getUUID(32));
            flag= userService.addUser(user);
        }
        ResultVo resultVo = new ResultVo();
        if(flag>0){
            resultVo.setCode(200);
            resultVo.setMsg("注册成功");
        }else {
            resultVo.setCode(REGEDITFIALCODE);
            resultVo.setMsg("注册失败");
        }
        return  resultVo;
    }

    /** 判断用户名是否存在 */
    @PostMapping(value = "/nameExist")
    @ResponseBody
    public ResultVo nameExist(HttpServletRequest request){
        String username =request.getParameter("username");
        int flag = userService.findUsername(username);
        ResultVo resultVo = new ResultVo();
        if(flag>0){
            resultVo.setCode(NAMEEXISTCODE);
            resultVo.setMsg("用户名已存在");
        }else {
            resultVo.setCode(200);
        }
        return resultVo;
    }

    /** 跳转至后台系统首页 */
    @PostMapping(value = "/toMenu")
    public String toMenu(HttpServletRequest request){
        return "menu/menu";
    }
}
