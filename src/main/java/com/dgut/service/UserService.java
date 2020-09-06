package com.dgut.service;

import com.alibaba.fastjson.JSONObject;

public interface UserService {
    JSONObject getAllUser();

    JSONObject updateUserInfo(JSONObject data);

    JSONObject addUser(JSONObject data);

    JSONObject delUser(JSONObject data);
}
