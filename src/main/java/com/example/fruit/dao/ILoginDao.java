package com.example.fruit.dao;

import com.example.fruit.entity.Login;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginDao {
    //登录
    Login login(@Param("username") String username, @Param("password") String password);
    //判断用户名是否存在
    Login findByUsername(@Param("username") String username);
    //注册
    boolean userRegister(@Param("username") String username,@Param("password") String password);
    //根据name找id
    Login searchIdByName(@Param("username") String username);
}
