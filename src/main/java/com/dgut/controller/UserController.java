package com.dgut.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    public JSONObject getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping("/modifyInfo")
    public JSONObject modifyInfo(@RequestBody JSONObject data){
        return userService.updateUserInfo(data);
    }

    @RequestMapping("/addUser")
    public JSONObject addUser(@RequestBody JSONObject data){
        return userService.addUser(data);
    }

    @RequestMapping("/delUser")
    public JSONObject delUser(@RequestBody JSONObject data){
        return userService.delUser(data);
    }
}
