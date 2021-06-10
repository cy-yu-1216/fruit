package com.example.fruit.service.impl;

import com.example.fruit.dao.ILoginDao;
import com.example.fruit.entity.Login;
import com.example.fruit.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {
    @Autowired
    private ILoginDao iLoginDao;
    //登录
    @Override
    public Login login(String username, String password) {
        return iLoginDao.login(username, password);
    }
    //判断用户名是否存在
    @Override
    public Login findByUsername(String username) {
        return iLoginDao.findByUsername(username);
    }

    //注册
    @Override
    public boolean userRegister(String username, String password) {
        return iLoginDao.userRegister(username,password);
    }

    //根据name找id
    @Override
    public Login searchIdByName(String username) {
        return iLoginDao.searchIdByName(username);
    }




}
