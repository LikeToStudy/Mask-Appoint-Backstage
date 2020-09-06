package com.dgut.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/contacts")
    public JSONObject contacts(){
        return feedbackService.getAllContacts();
    }

    @RequestMapping("/contactDelete")
    public JSONObject contactDelete(@RequestBody JSONObject data){
        return feedbackService.deleteContact(data);
    }

    @RequestMapping("/messages")
    public JSONObject messages(){
        return feedbackService.getAllMessages();
    }

    @RequestMapping("/mesDel")
    public JSONObject mesDel(@RequestBody JSONObject data){
        return feedbackService.deleteMessage(data);
    }
}
