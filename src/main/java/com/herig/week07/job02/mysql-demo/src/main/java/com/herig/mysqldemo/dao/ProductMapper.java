package com.herig.mysqldemo.dao;

import com.herig.mysqldemo.pojo.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    List<Product> queryProductList();

    int insertProductMuti(List<Product> productList);
}
