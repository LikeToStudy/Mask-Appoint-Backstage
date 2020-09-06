package com.dgut.domin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.UUID;

public class NeedProduct {
    @JSONField(name = "needProductId")
    private String proID;
    @JSONField(name = "needProduct")
    private String proName;

    public NeedProduct(String proName) {
        this.proID = UUID.randomUUID().toString();
        this.proName = proName;
    }

    @Override
    public String toString() {
        return "NeedProduct{" +
                "proID='" + proID + '\'' +
                ", proName='" + proName + '\'' +
                '}';
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
}
