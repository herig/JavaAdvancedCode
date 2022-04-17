package com.herig.mysqldemo.service.impl;

import com.herig.mysqldemo.dao.ProductMapper;
import com.herig.mysqldemo.pojo.Product;
import com.herig.mysqldemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> queryProductList() {
        return productMapper.queryProductList();
    }

    @Override
    public void insertProductMuti() {
        long startTime=System.currentTimeMillis();
        for(int i=0;i<500;i++){
            List<Product> productList = new ArrayList<>();
            for(int j = 1;j<=2000;j++){


                Product newProduct = new Product();
                newProduct.setProductId(i*2000+j+2);
                newProduct.setProductNumber("20220417" + (i*2000+j+2));
                newProduct.setProductName("康师傅红烧牛肉面" + (i*2000+j+2));
                newProduct.setProductType("食品");
                newProduct.setPrice(3.5D);
                newProduct.setQuantity(1);
                newProduct.setSupplierId(1);
                newProduct.setWeight(0.125);
                newProduct.setUnit("kg");
                Date date = new Date();
                newProduct.setCreateTime(date);
                newProduct.setLastupdateTime(date);
                productList.add(newProduct);
            }
            productMapper.insertProductMuti(productList);
        }
        long endTime=System.currentTimeMillis();

        System.out.println("当前程序耗时：" + (endTime-startTime) + "ms");




    }
}
