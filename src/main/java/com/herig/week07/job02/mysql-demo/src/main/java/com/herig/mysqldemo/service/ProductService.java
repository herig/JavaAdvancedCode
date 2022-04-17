package com.herig.mysqldemo.service;

import com.herig.mysqldemo.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> queryProductList();

    void insertProductMuti();
}
