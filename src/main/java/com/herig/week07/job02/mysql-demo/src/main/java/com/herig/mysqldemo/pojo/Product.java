package com.herig.mysqldemo.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Product {

    private int productId;
    private String productNumber;
    private String productName;
    private String productType;
    private Double price;
    private int quantity;
    private Double weight;
    private String unit;
    private int supplierId;
    private Date createTime;
    private Date lastupdateTime;


}
