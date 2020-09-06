package com.dgut.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dgut.domin.Contact;
import com.dgut.domin.Message;
import com.dgut.mapper.FeedbackMapper;
import com.dgut.service.FeedbackService;
import com.dgut.util.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackMapper feedbackMapper;
    private JsonHelper jsonHelper;

    @Autowired
    public FeedbackServiceImpl(FeedbackMapper feedbackMapper, JsonHelper jsonHelper){
        this.feedbackMapper = feedbackMapper;
        this.jsonHelper = jsonHelper;
    }

    @Override
    public JSONObject getAllContacts() {
        List<Contact> list = feedbackMapper.getAllContact();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("contacts", list);
        return jsonObject;
    }

    @Override
    public JSONObject getAllMessages() {
        List<Message> list = feedbackMapper.getAllMessages();
        JSONObject data = new JSONObject();
        data.put("messages", list);
        return data;
    }

    @Override
    public JSONObject deleteContact(JSONObject data) {
        String contactId = data.getString("contactId");
        System.out.println(contactId);
        int result = feedbackMapper.contactDelete(contactId);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }

    @Override
    public JSONObject deleteMessage(JSONObject data) {
        String mesID = data.getString("messageId");
        int result = feedbackMapper.messageDelete(mesID);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }
    /*
    * url: "http://localhost:8081/getAllPro",
    * http://localhost:8081/updateStock
    * http://localhost:8081/addProduct
    * http://localhost:8081/proDel
    * contentType : "application/json",*/

}
