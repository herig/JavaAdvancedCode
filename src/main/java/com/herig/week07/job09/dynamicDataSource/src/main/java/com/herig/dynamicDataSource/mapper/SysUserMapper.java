package com.herig.dynamicDataSource.mapper;


import com.herig.dynamicDataSource.dto.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Qian Yuanfeng
 * @date 2022/4/17 - 18:58
 */
@Repository
public interface SysUserMapper {

    List<SysUser> querySysUserMaster();

    List<SysUser> querySysUserSlave();

}
