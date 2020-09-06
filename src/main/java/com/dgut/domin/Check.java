package com.dgut.domin;

import java.util.Random;
import java.util.UUID;

public class Check {
    private String checkID;
    private String checkNum;

    public Check() {
        checkID = UUID.randomUUID().toString();
        checkNum = randomCode();
    }


    public static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    public String getCheckID() {
        return checkID;
    }

    public void setCheckID(String checkID) {
        this.checkID = checkID;
    }

    public String getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }
}
