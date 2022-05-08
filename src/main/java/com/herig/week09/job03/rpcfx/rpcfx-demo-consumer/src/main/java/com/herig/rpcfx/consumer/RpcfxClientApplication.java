package com.herig.rpcfx.consumer;


import com.herig.rpcfx.api.Filter;
import com.herig.rpcfx.api.LoadBalancer;
import com.herig.rpcfx.api.Router;
import com.herig.rpcfx.api.RpcfxRequest;
import com.herig.rpcfx.client.Rpcfx;
import com.herig.rpcfx.demo.api.User;
import com.herig.rpcfx.demo.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RpcfxClientApplication {

	// 二方库
	// 三方库 lib
	// nexus, userserivce -> userdao -> user
	//

	public static void main(String[] args) {
		rpcfxTest();
	}

	public static void rpcfxTest(){
		UserService userService = Rpcfx.create(UserService.class, "http://localhost:8080/");
		User user = userService.findById(1);
		System.out.println("find user id=1 from server: " + user.getName());
	}


}



