package com.example.fruit.service.impl;

import com.example.fruit.dao.IFruitDao;
import com.example.fruit.entity.Fruit;
import com.example.fruit.service.IFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FruitService implements IFruitService {

    @Autowired
    private IFruitDao iFruitDao;
    //查找所有水果
    @Override
    public List<Fruit> searchAll() {
        return iFruitDao.searchAll();
    }
    //根据ID查找水果
    @Override
    public List<Fruit> searchId(int fruit_id) {
        return iFruitDao.searchId(fruit_id);
    }
    //根据种类查找水果
    @Override
    public List<Fruit> searchCategory(String fruit_category) {
        return iFruitDao.searchCategory(fruit_category);
    }

    //感兴趣加一
    @Override
    public boolean addInterest(int fruit_id) {
        return iFruitDao.addInterest(fruit_id);
    }

    @Override
    public boolean reduceInterest(int fruit_id) {
        return iFruitDao.reduceInterest(fruit_id);
    }
}
