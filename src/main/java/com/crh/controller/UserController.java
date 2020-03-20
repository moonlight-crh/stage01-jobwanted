package com.crh.controller;

import com.crh.entity.SysUsr;
import com.crh.myConfig.LogAspect;
import com.crh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author crh
 * @date 2020-03-18 15:41
 */
@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Autowired
    UserService userService;
//跳转到注册页面
    @RequestMapping("/registerForward")
    public String registerForward(){
        return "register";
    }
//注册 新增用户
    @RequestMapping("/register")
    public String addUser(SysUsr sysUsr){
        userService.addUser(sysUsr);
        return "login";
    }
//跳转到用户登录页面
    @RequestMapping("/loginForward")
    public String loginForward(){
        return "login";
    }
    //用户登录 跳转到用户列表页面
    @RequestMapping("/login")
    public String register( Map map){
        List<SysUsr> sysUsrs = userService.selectAll();
        for (SysUsr sysUsr : sysUsrs) {
            sysUsr.toString();
        }
        map.put("userList",sysUsrs);
        return "userList";
    }


}
