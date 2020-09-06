package com.dgut.domin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.UUID;

/*             *                            "contactId" : contactId ,
                     "contactName" : contactName ,
                     "contactUsername" : contactUsername ,
                     "contactEmail" : contactEmail ,
                     "contactPhone" : contactPhone ,
                     "contactMessage" : contactMessage*/
public class Contact {
    @JSONField(name = "contactId")
    private String contactID;
    private String contactName;
    @JSONField(name = "contactUsername")
    private String contactUserName;
    private String contactEmail;
    private String contactPhone;
    private String contactMessage;

    public Contact() {
        super();
    }

    public Contact(String contactName, String contactUserName, String contactEmail, String contactPhone, String contactMessage) {
        this.contactID = UUID.randomUUID().toString();
        this.contactName = contactName;
        this.contactUserName = contactUserName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.contactMessage = contactMessage;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactID='" + contactID + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactUserName='" + contactUserName + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactMessage='" + contactMessage + '\'' +
                '}';
    }

    public String getContactID() {
        return contactID;
    }

    public void setContactID(String contactID) {
        this.contactID = contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactUserName() {
        return contactUserName;
    }

    public void setContactUserName(String contactUserName) {
        this.contactUserName = contactUserName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactMessage() {
        return contactMessage;
    }

    public void setContactMessage(String contactMessage) {
        this.contactMessage = contactMessage;
    }
}
