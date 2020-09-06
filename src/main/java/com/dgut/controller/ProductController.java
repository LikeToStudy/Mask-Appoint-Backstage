package com.dgut.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*Controller层仅用来接收前端数据、调用Service层方法，并返回数据
* 不涉及数据解析、逻辑处理等其他功能
*
* 同时，仅IndexController用来返回默认页面，而其他Controller都用来处理非静态资源请求
*
* 规定用json传输数据，且Controller直接将json对象传递给Service*/

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/getAllNeed")
    public JSONObject getAllNeed(){
        return productService.getAllNeed();
    }

    @RequestMapping("/getAllPro")
    public JSONObject getAllPro(){
        return productService.getAllPro();
    }

    @RequestMapping("/needDel")
    public JSONObject needDel(@RequestBody JSONObject data){
        return productService.deleteNeed(data);
    }

    @RequestMapping("/updateStock")
    public JSONObject updateStock(@RequestBody JSONObject data){
        return productService.updateStock(data);
    }

    @RequestMapping("/addProduct")
    public JSONObject addProduct(@RequestBody JSONObject data){
        return productService.addProduct(data);
    }

    @RequestMapping("/proDel")
    public JSONObject proDel(@RequestBody JSONObject data){
        return productService.deletePro(data);
    }
}
