package com.example.fruit.service;

import com.example.fruit.entity.Login;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ILoginService {
    //登录
    Login login(String username, String password);
    //判断用户名是否存在
    Login findByUsername(String username);
    //注册
    boolean userRegister(String username, String password);
    //根据name找id
//    int findIdByName(String username);
    Login searchIdByName(String username);
}
