package com.dgut.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpSession;

public interface AdminService {
    JSONObject login(JSONObject data, HttpSession session);

    JSONObject register(JSONObject data, HttpSession session);

    JSONObject isLogin(HttpSession session);

    JSONObject logout(HttpSession session);

    JSONObject getUserInfo(HttpSession session);
}
