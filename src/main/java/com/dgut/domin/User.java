package com.dgut.domin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Random;
import java.util.UUID;
public class User {
    @JSONField(name = "userId")
    private String userID;
    @JSONField(name = "userName")
    private String username;
    @JSONField(name = "password")
    private String password;
    @JSONField(name = "userSex")
    private String userSex;
    @JSONField(name = "userBirth")
    private String userBirth;
    @JSONField(name = "userPhone")
    private String userPhone;
    @JSONField(name = "userNation")
    private String userNation;
    @JSONField(name = "userAddress")
    private String userAddress;
    @JSONField(name = "userPhoneNumber")
    private String userReceiptPhone;
    @JSONField(name = "userEmail")
    private String userEmail;

    public User() {
        super();
    }

    public User(String username, String password) {
        this.userID = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }

    public User(String userID, String username, String userSex, String userBirth, String userPhone, String userNation, String userAddress, String userReceiptPhone, String userEmail) {
        this.userID = userID;
        this.username = username;
        this.userSex = userSex;
        this.userBirth = userBirth;
        this.userPhone = userPhone;
        this.userNation = userNation;
        this.userAddress = userAddress;
        this.userReceiptPhone = userReceiptPhone;
        this.userEmail = userEmail;
    }

    public User(String userID, String username, String password, String userSex, String userBirth, String userPhone, String userNation, String userAddress, String userReceiptPhone, String userEmail) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.userSex = userSex;
        this.userBirth = userBirth;
        this.userPhone = userPhone;
        this.userNation = userNation;
        this.userAddress = userAddress;
        this.userReceiptPhone = userReceiptPhone;
        this.userEmail = userEmail;
    }

    public static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    public User(String username, String userSex, String userBirth, String userPhone, String userNation, String userAddress, String userReceiptPhone, String userEmail) {
        this.userID = UUID.randomUUID().toString();
        this.password = randomCode();
        this.username = username;
        this.userSex = userSex;
        this.userBirth = userBirth;
        this.userPhone = userPhone;
        this.userNation = userNation;
        this.userAddress = userAddress;
        this.userReceiptPhone = userReceiptPhone;
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userNation='" + userNation + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userReceiptPhone='" + userReceiptPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserNation() {
        return userNation;
    }

    public void setUserNation(String userNation) {
        this.userNation = userNation;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserReceiptPhone() {
        return userReceiptPhone;
    }

    public void setUserReceiptPhone(String userReceiptPhone) {
        this.userReceiptPhone = userReceiptPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
