package com.herig.mysqldemo.controllers;

import com.herig.mysqldemo.pojo.Product;
import com.herig.mysqldemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/hello2")
    public List<Product> queryProduct(){
        return productService.queryProductList();
    }

    @GetMapping("/test/insertProductMuti")
    public void insertProductMuti(){
        productService.insertProductMuti();
    }
}
