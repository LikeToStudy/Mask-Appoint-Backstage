package com.dgut.domin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.UUID;

public class Product {
    @JSONField(name = "productId")
    private String proID;
    @JSONField(name = "productName")
    private String proName;
    @JSONField(name = "productStock")
    private int proStock;

    public Product() {
        super();
    }

    public Product(String proName, int proStock) {
        this.proID = UUID.randomUUID().toString();
        this.proName = proName;
        this.proStock = proStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proID='" + proID + '\'' +
                ", proName='" + proName + '\'' +
                ", proStock=" + proStock +
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

    public int getProStock() {
        return proStock;
    }

    public void setProStock(int proStock) {
        this.proStock = proStock;
    }
}
