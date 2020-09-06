package com.dgut.domin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.UUID;

public class Message {
    @JSONField(name = "messageId")
    private String mesID;
    @JSONField(name = "message")
    private String mesContent;

    public Message() {
        super();
    }

    public Message(String mesContent) {
        this.mesID = UUID.randomUUID().toString();
        this.mesContent = mesContent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "mesID='" + mesID + '\'' +
                ", mesContent='" + mesContent + '\'' +
                '}';
    }

    public String getMesID() {
        return mesID;
    }

    public void setMesID(String mesID) {
        this.mesID = mesID;
    }

    public String getMesContent() {
        return mesContent;
    }

    public void setMesContent(String mesContent) {
        this.mesContent = mesContent;
    }
}
