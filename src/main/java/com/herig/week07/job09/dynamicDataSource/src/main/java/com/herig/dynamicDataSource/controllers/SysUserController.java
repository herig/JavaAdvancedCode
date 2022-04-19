package com.herig.dynamicDataSource.controllers;


import com.herig.dynamicDataSource.dto.SysUser;
import com.herig.dynamicDataSource.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Qian Yuanfeng
 * @date 2022/4/17 - 18:55
 */
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @GetMapping("/hello1")
    public List<SysUser> querySysUserMaster(){
        return sysUserService.querySysUserMaster();
    }

    @GetMapping("/hello2")
    public List<SysUser> querySysUserSlave(){
        return sysUserService.querySysUserSlave();
    }

}
