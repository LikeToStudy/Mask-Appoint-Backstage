package com.dgut.service;

import com.alibaba.fastjson.JSONObject;

public interface AppointService {
    JSONObject getAllAppoint();

    JSONObject deleteAppoint(JSONObject data);
}
