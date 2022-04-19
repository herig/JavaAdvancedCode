package com.herig.dynamicDataSource.dto;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author Qian Yuanfeng
 * @date 2022/4/17 - 18:51
 */
@Data
public class SysUser {
    private BigInteger userId;

    private String userName ;

    private String password ;
    private String nickName ;
    private String idNumber ;
    private String phoneNumber ;
    private Date createTime;
    private Date lastupdateTime;


}
