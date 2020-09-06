package com.dgut.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dgut.domin.NeedProduct;
import com.dgut.domin.Product;
import com.dgut.mapper.ProductMapper;
import com.dgut.service.ProductService;
import com.dgut.util.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductMapper productMapper;
    private JsonHelper jsonHelper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper, JsonHelper jsonHelper){
        this.productMapper = productMapper;
        this.jsonHelper = jsonHelper;
    }

    @Override
    public JSONObject getAllNeed() {
        List<NeedProduct> list = productMapper.getAllNeed();
        JSONObject data = new JSONObject();
        data.put("needProducts", list);
        return data;
    }

    @Override
    public JSONObject getAllPro() {
        List<Product> list = productMapper.getAllProduct();
        JSONObject data = new JSONObject();
        data.put("products", list);
        return data;
    }

    @Override
    public JSONObject deleteNeed(JSONObject data) {
        String needProductId = data.getString("needProductId");
        System.out.println(needProductId);
        int result = productMapper.deleteNeed(needProductId);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }

    @Override
    public JSONObject deletePro(JSONObject data) {
        String productId = data.getString("productId");
        int result = productMapper.deletePro(productId);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }

    @Override
    public JSONObject updateStock(JSONObject data) {
        String proID = data.getString("productId");
        int stock = Integer.parseInt(data.getString("productStock"));
        int result = productMapper.updateStock(proID, stock);
        if (result > 0) return jsonHelper.operator(1);
        else return jsonHelper.operator(2);
    }

    @Override
    public JSONObject addProduct(JSONObject data) {
        String proName = data.getString("productName");
        String stock = data.getString("productStock").trim();
        int proStock = Integer.parseInt(stock);
        String pro_id = productMapper.getProIDByProName(proName);
        System.out.println(proName);
        if (pro_id == null || pro_id.equals("")){
            Product product = new Product(proName, proStock);
            int result = productMapper.insertProduct(product);
            if (result > 0) return jsonHelper.operator(1);
            else return jsonHelper.operator(2);
        }
        else {
            int newProStock = productMapper.getProStockByProID(pro_id);
            proStock = newProStock + proStock;
            int result = productMapper.updateStock(pro_id, proStock);
            if (result > 0) return jsonHelper.operator(1);
            else return jsonHelper.operator(2);
        }
    }
}
