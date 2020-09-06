package com.dgut.service;

import com.alibaba.fastjson.JSONObject;

public interface FeedbackService {
    JSONObject getAllContacts();

    JSONObject getAllMessages();

    JSONObject deleteContact(JSONObject data);

    JSONObject deleteMessage(JSONObject data);
}
