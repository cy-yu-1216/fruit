package com.example.fruit.dao;

import com.example.fruit.entity.Fruit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFruitDao {
    //查找所有水果
    List<Fruit> searchAll();
    //根据ID查找水果
    List<Fruit> searchId(@Param("fruit_id") int fruit_id);
    //根据种类查找水果
    List<Fruit> searchCategory(@Param("fruit_category") String fruit_category);
    //感兴趣加一
    boolean addInterest(@Param("fruit_id") int fruit_id);
    //感兴趣减一
    boolean reduceInterest(@Param("fruit_id") int fruit_id);
}
