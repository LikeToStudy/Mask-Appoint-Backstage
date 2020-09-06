package com.dgut.mapper;

import com.dgut.domin.Contact;
import com.dgut.domin.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackMapper {
    /*select*/
    List<Contact> getAllContact();

    List<Message> getAllMessages();

    /*delete*/
    int contactDelete(String contactID);

    int messageDelete(String mesID);
}
