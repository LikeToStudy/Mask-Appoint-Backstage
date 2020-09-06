package com.dgut.controller;
import com.alibaba.fastjson.JSONObject;
import com.dgut.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/loginSubmit")
    public JSONObject login(@RequestBody JSONObject data, HttpSession session){
        return adminService.login(data, session);
    }

    @RequestMapping("/register")
    public JSONObject register(@RequestBody JSONObject data, HttpSession session){
        return adminService.register(data, session);
    }
}
