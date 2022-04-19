package com.herig.dynamicDataSource.service.impl;

import com.herig.dynamicDataSource.datasource.CurDataSource;
import com.herig.dynamicDataSource.datasource.DataSourceNames;
import com.herig.dynamicDataSource.dto.SysUser;
import com.herig.dynamicDataSource.mapper.SysUserMapper;
import com.herig.dynamicDataSource.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Qian Yuanfeng
 * @date 2022/4/17 - 23:15
 */
@Service
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    @CurDataSource(name = DataSourceNames.FIRST)
    public List<SysUser> querySysUserMaster() {

        return sysUserMapper.querySysUserMaster();
    }

    @Override
    @CurDataSource(name = DataSourceNames.SECOND)
    public List<SysUser> querySysUserSlave() {

        return sysUserMapper.querySysUserSlave();
    }

}
