package com.herig.useShardingProxy.dto;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class GooseOrderInfo {

    private BigInteger orderId;

    private String orderNumber ;

    private BigInteger userId ;

    private Double totalPrice ;
    private Double totalDiscountPrice ;

    private String orderStatus ;
    private BigInteger logisticsId ;
    private Integer sendProvince;
    private Integer sendCity;
    private Integer sendDistrict;
    private String sendAddress;

    private Integer receiveProvince;
    private Integer receiveCity;
    private Integer receiveDistrict;
    private String  receiveAddress;

    private Date createTime;
    private Date lastupdateTime;

}


