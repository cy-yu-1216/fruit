package com.example.fruit.controller;


import com.example.fruit.entity.Fruit;
import com.example.fruit.entity.Login;
import com.example.fruit.entity.Store;
import com.example.fruit.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/store")
public class StoreController {

    @Autowired
    private IStoreService iStoreService;
//    根据用户id找所有他存的水果
    @RequestMapping(value = "/storeId", method = RequestMethod.GET)
    private List<Fruit> findByUserId(@RequestParam int id) {
        return iStoreService.findByUserId(id);
    }
    //根据水果id和用户id判断这个水果是否被存储
    @RequestMapping(value = "store2", method = RequestMethod.POST)
    private String getStore(@RequestBody Store store) {
        Store store1 = iStoreService.getStore(store.getFruit_id(), store.getId());
        if (store1!= null) {
            return "true";
        }else {
            return "false";
        }
    }
    //根据水果id和用户id收藏水果
    @RequestMapping(value = "storeFruit", method = RequestMethod.POST)
    private String storeFruit(@RequestBody Store store) {
        Store store1 = iStoreService.getStore(store.getFruit_id(), store.getId());
        if (store1!= null) {
            //数据库中有这条数据就把这条数据，说明不能存
            return "false";
        }else {
            iStoreService.storeFruit(store.getFruit_id(), store.getId());
            return "true";
        }
    }
    //根据水果id和用户id删除该水果的收藏
    @RequestMapping(value = "deleteStore", method = RequestMethod.POST)
    private String deleteStore(@RequestBody Store store) {
        Store store1 = iStoreService.getStore(store.getFruit_id(), store.getId());
        if (store1!= null) {
            //数据库中有这条数据就把这条数据删除
            iStoreService.deleteStore(store.getFruit_id(), store.getId());
            return "true";

        }else {
//            没有但会false
            return "false";
        }

    }
}
