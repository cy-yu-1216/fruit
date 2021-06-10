package com.example.fruit.controller;

import com.example.fruit.entity.Fruit;
import com.example.fruit.service.IFruitService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/fruit")
public class FruitController {

    @Autowired
    private IFruitService iFruitService;

    //查找所有水果
    @RequestMapping(value = "/fruit1", method = RequestMethod.GET)
    private List<Fruit> searchAll() {
//        System.out.println("水果列表aaaaaa");
//        System.out.println(aa);
        return iFruitService.searchAll();
    }

    //根据水果id找到相应水果列表
    @RequestMapping(value = "/fruitId", method = RequestMethod.GET)
    private List<Fruit> searchId(@RequestParam int fruit_id) {
//        System.out.println(iFruitService.searchId(fruit_id));
        return iFruitService.searchId(fruit_id);
    }
    //根据水果种类找相应的水果
    @RequestMapping(value = "/fruitCategory", method = RequestMethod.GET)
    private List<Fruit> searchCategory(@RequestParam String fruit_category) {
        return iFruitService.searchCategory(fruit_category);
    }
    //感兴趣加一
    @RequestMapping(value = "/fruitAddInterest", method = RequestMethod.GET)
    private boolean addInterest(@RequestParam int fruit_id) {
        return iFruitService.addInterest(fruit_id);
    }
    //感兴趣减一
    @RequestMapping(value = "/fruitReduceInterest", method = RequestMethod.GET)
    private boolean reduceInterest(@RequestParam int fruit_id) {
        return iFruitService.reduceInterest(fruit_id);
    }


}
