package com.example.fruit.service;

import com.example.fruit.entity.Fruit;

import java.util.List;

public interface IFruitService {
    //查找所有水果
    List<Fruit> searchAll();
    //根据id查找水果
    List<Fruit> searchId(int fruit_id);
    //根据种类查找水果
    List<Fruit> searchCategory(String fruit_category);
    //感兴趣加一
    boolean addInterest(int fruit_id);
    //感兴趣减1
    boolean reduceInterest(int fruit_id);
}
