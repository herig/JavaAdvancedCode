package com.herig.dynamicDataSource;

import com.herig.dynamicDataSource.dto.SysUser;
import com.herig.dynamicDataSource.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class DynamicDataSourceApplicationTests {


	@Autowired
	private SysUserService userService;


	@Test
	public void test() {
		List<SysUser> sysUsersMaster = userService.querySysUserMaster();
		log.info("第一个数据库 : [{}]", Arrays.asList(sysUsersMaster));
		List<SysUser> sysUsersSlave = userService.querySysUserSlave();
		log.info("第二个数据库 : [{}]",  Arrays.asList(sysUsersMaster));
	}

}
