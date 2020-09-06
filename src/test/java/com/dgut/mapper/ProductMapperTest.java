package com.dgut.mapper;

import com.dgut.domin.NeedProduct;
import com.dgut.domin.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//读取配置文件，使@Autowired生效
@ContextConfiguration(locations = "classpath:application-context.xml")
public class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void TestGetAllNeed(){
        List<NeedProduct> list = productMapper.getAllNeed();
        for (NeedProduct n:list) System.out.println(n);
    }

    @Test
    public void TestDeleteNeed(){
        productMapper.deleteNeed("0f13af47-7d39-4846-9317-ca72ccced829");
    }

    @Test
    public void TestGetAllProduct(){
        List<Product> list = productMapper.getAllProduct();
        for (Product p:list) System.out.println(p);
    }

    @Test
    public void TestUpdateStock(){
        productMapper.updateStock("fd425950-59ab-495b-a49d-1a751e387173", 2000);
    }

    @Test
    public void TestDeletePro(){
        productMapper.deletePro("ssssssssssssssss");
    }

    @Test
    public void TestGetProIDByProName(){
        System.out.println(productMapper.getProIDByProName("N95防护口罩"));
    }

    @Test
    public void TestInsertProduct(){
        Product product = new Product("测试口罩", 1000);
        productMapper.insertProduct(product);
    }
}
