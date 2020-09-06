package com.dgut.mapper;

import com.dgut.domin.Contact;
import com.dgut.domin.Message;
import com.dgut.domin.NeedProduct;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//读取配置文件，使@Autowired生效
@ContextConfiguration(locations = "classpath:application-context.xml")
public class FeedbackMapperTest {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Test
    public void TestGetAllContact(){
        List<Contact> list = feedbackMapper.getAllContact();
        for (Contact c:list) System.out.println(c);
    }

    @Test
    public void TestContactDelete(){
        String contactID = "ca5a7bdb-af8f-4ea5-bdc2-c88eede0b15c";
        int result = feedbackMapper.contactDelete(contactID);
        System.out.println(result);
    }

    @Test
    public void TestGetAllMessages(){
        List<Message> list = feedbackMapper.getAllMessages();
        for (Message s:list) System.out.println(s);
    }

    @Test
    public void TestMessageDelete(){
        String mesID = "70f8cfbe-af56-4448-8c4b-9d51e6cb657c";
        feedbackMapper.messageDelete(mesID);
    }

}
