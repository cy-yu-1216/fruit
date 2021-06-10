package com.example.fruit.controller;

import com.example.fruit.entity.Fruit;
import com.example.fruit.entity.Login;
import com.example.fruit.service.ILoginService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private ILoginService iLoginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Login login(@RequestParam String username, @RequestParam String password) {
        return iLoginService.login(username, password);
    }

    /**
     * 登录
     * @param login
     * @return
     */
    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    private String login(@RequestBody Login login) {
        Login user = iLoginService.login(login.getUsername(), login.getPassword());
        if (user!= null) {
            return "登录成功";
        }else {
            return "用户名或密码错误";
        }
    }

    /**
     * 根据用户名找id
     * @param username
     * @return
     */
    @RequestMapping(value = "/getIdByName",method = RequestMethod.GET)
    private Login searchIdByName(@RequestParam String username){
        return iLoginService.searchIdByName(username);
    }

    /**
     * 注册
     * @param login
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private String register(@RequestBody Login login) {
        Login user = iLoginService.findByUsername(login.getUsername());
        if (user!= null) {
            return "用户名已存在";
        }else {
            boolean register = iLoginService.userRegister(login.getUsername(),login.getPassword());
            if(register){
                return "注册成功";
            }
            else {
                return "注册失败";
            }
        }
    }

}
