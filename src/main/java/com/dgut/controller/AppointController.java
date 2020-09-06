package com.dgut.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.service.AppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointController {

    @Autowired
    private AppointService appointService;

    @RequestMapping("/getAllAppoint")
    public JSONObject getAllAppoint(){
        return appointService.getAllAppoint();
    }

    @RequestMapping("/delAppoint")
    public JSONObject delAppoint(@RequestBody JSONObject data){
        return appointService.deleteAppoint(data);
    }
}
