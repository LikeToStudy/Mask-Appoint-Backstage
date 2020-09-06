package com.dgut.domin;

import com.alibaba.fastjson.annotation.JSONField;

/*预约三天后自动完成订单*/
public class TempAppoint {
    @JSONField(name = "appointmentId")
    private String logID;
    @JSONField(name = "userName")
    private String username;
    @JSONField(name = "appointmentTime")
    private String appointTime;
    @JSONField(name = "appointmentSpeed")
    private String appointSpeed;

    public TempAppoint() {
        super();
    }

    public TempAppoint(String userID, String username, String appointTime, String appointSpeed) {
        this.logID = userID;
        this.username = username;
        this.appointTime = appointTime;
        this.appointSpeed = appointSpeed;
    }

    public String getLogID() {
        return logID;
    }

    public void setLogID(String logID) {
        this.logID = logID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }

    public String getAppointSpeed() {
        return appointSpeed;
    }

    public void setAppointSpeed(String appointSpeed) {
        this.appointSpeed = appointSpeed;
    }
}
