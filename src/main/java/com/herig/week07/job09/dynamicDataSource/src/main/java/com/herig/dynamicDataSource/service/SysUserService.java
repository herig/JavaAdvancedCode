package com.herig.dynamicDataSource.service;

import com.herig.dynamicDataSource.dto.SysUser;

import java.util.List;

/**
 * @author Qian Yuanfeng
 * @date 2022/4/17 - 23:15
 */

public interface SysUserService {

    List<SysUser> querySysUserMaster();

    List<SysUser> querySysUserSlave();


}
