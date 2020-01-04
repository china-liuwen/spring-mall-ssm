package com.controller;

import com.entity.UserEntity;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/be")

public class LoginController {
    @Autowired
    private UserService userService;

    //主页面

    @RequestMapping("/index")
    public String index(){
        return "/be/index";
    }

    //注册

    @RequestMapping("/zce")
    public String zce(){
        return "/be/zce";
    }

    //登录视图

    @RequestMapping("/login")
    public String login(){
        return "/be/loginView";
    }

    //登录的验证

    @RequestMapping("/login1")
    public String login(String username, String password, HttpSession session){
        List<UserEntity> result = userService.getAll();
        for (UserEntity userEntity : result) {
            if (userEntity.getUsername().equalsIgnoreCase(username) &&
                 userEntity.getPassword().equals(password)){
                session.setAttribute("username",username);
                System.out.printf("登录成功。。。。");
                return "/be/index";
            }
        }

        return "redirect:/be/login";
    }

    //退出登录

    @RequestMapping("/exit")
    public void exit(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println("退出登录。。。。");
        //销毁会话
        session.invalidate();
    }
//
//    @RequestMapping("/tuichu")
//    public void tuichu(HttpSession session){
//        System.out.println("退出登录了。");
//        session.invalidate();
//    }

//
    //错误地址404

    @RequestMapping("/error")
    public String error(){
        return "/error";
    }
}



























