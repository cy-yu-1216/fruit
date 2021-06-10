package com.example.fruit.service;


import com.example.fruit.entity.Fruit;
import com.example.fruit.entity.Store;

import java.util.List;

public interface IStoreService {
    //根据用户id找收藏列表
    List<Fruit> findByUserId(int id);
    //根据水果id和用户id判断这个水果是否被存储
    Store getStore(int fruit_id,int id);
    //根据水果id和用户id收藏水果
    boolean storeFruit(int fruit_id, int id);

    //根据水果id和用户id删除该水果的收藏
    boolean deleteStore(int fruit_id, int id);
}
