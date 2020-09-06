package com.dgut.mapper;

import com.alibaba.fastjson.JSONObject;
import com.dgut.domin.NeedProduct;
import com.dgut.domin.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    List<NeedProduct> getAllNeed();

    List<Product> getAllProduct();

    int deleteNeed(String needID);

    int deletePro(String proID);

    int updateStock(String proID, int stock);

    int insertProduct(Product product);

    String getProIDByProName(String proName);

    int getProStockByProID(String proID);

}
