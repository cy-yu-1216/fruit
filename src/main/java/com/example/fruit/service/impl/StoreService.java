package com.example.fruit.service.impl;

import com.example.fruit.dao.IStoreDao;
import com.example.fruit.entity.Fruit;
import com.example.fruit.entity.Store;
import com.example.fruit.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService implements IStoreService {

    @Autowired
    private IStoreDao iStoreDao;

    //根据用户id找收藏列表
    @Override
    public List<Fruit> findByUserId(int id) {
        return iStoreDao.findByUserId(id);
    }

    //根据水果id和用户id判断这个水果是否被存储//根据水果id和用户id收藏水果
    @Override
    public Store getStore(int fruit_id, int id) {
        return iStoreDao.getStore(fruit_id,id);
    }

    //根据水果id和用户id收藏水果
    @Override
    public boolean storeFruit(int fruit_id, int id) {
        return iStoreDao.storeFruit(fruit_id,id);
    }

    //根据水果id和用户id删除该水果的收藏
    @Override
    public boolean deleteStore(int fruit_id, int id) {
        return iStoreDao.deleteStore(fruit_id,id);
    }
}
