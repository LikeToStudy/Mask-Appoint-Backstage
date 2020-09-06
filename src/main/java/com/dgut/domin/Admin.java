package com.dgut.domin;

import java.util.UUID;

public class Admin {
    private String adminID;
    private String adminName;
    private String adminPassword;

    public Admin() {
        super();
    }

    public Admin(String adminName, String adminPassword) {
        this.adminID = UUID.randomUUID().toString();
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID='" + adminID + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
