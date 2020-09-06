package com.dgut.service;

import com.alibaba.fastjson.JSONObject;

public interface ProductService {
    JSONObject getAllNeed();

    JSONObject getAllPro();

    JSONObject deleteNeed(JSONObject data);

    JSONObject deletePro(JSONObject data);

    JSONObject updateStock(JSONObject data);

    JSONObject addProduct(JSONObject data);
}
