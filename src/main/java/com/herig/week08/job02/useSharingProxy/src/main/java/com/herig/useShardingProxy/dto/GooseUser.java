package com.herig.useShardingProxy.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GooseUser {

    private int userId;

    private String userName;
    private String userPassword;
    private String idNumber;
    private String nickName;
    private String phoneNumber;
    private Date createTime;
    private Date lastupdateTime;

}
