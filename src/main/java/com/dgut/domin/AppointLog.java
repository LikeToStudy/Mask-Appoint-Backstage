package com.dgut.domin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/*预约三天后自动完成订单*/
public class AppointLog {
    private String logID;
    private String userID;
    private String appointTime;
    private int isComplete;

    public AppointLog() {
        super();
    }

    public AppointLog(String userID, int isComplete) {
        this.logID = UUID.randomUUID().toString();
        this.userID = userID;
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.appointTime = format0.format(new Date().getTime());
        this.isComplete = isComplete;
    }

    @Override
    public String toString() {
        return "AppointLog{" +
                "logID='" + logID + '\'' +
                ", userID='" + userID + '\'' +
                ", appointTime='" + appointTime + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }

    public int getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(int isComplete) {
        this.isComplete = isComplete;
    }

    public String getLogID() {
        return logID;
    }

    public void setLogID(String logID) {
        this.logID = logID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }
}
