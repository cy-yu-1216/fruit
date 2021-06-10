package com.example.fruit.dao;

import com.example.fruit.entity.Fruit;
import com.example.fruit.entity.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStoreDao {
    //根据用户id找收藏列表
    List<Fruit> findByUserId(@Param(value = "id") int id);
    //根据水果id和用户id判断这个水果是否被存储
    Store getStore(@Param("fruit_id") int fruit_id,@Param("id") int id);
    //根据水果id和用户id收藏水果
    boolean storeFruit(@Param("fruit_id") int fruit_id, @Param("id") int id);
    //根据水果id和用户id删除该水果的收藏
    boolean deleteStore(@Param("fruit_id") int fruit_id, @Param("id") int id);
}
