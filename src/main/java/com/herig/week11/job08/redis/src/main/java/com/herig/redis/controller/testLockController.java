package com.herig.redis.controller;

import com.herig.redis.lock.RedisLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@RestController
public class testLockController {

    @Autowired
    RedisLockService redisLockService;

    @RequestMapping("/test/redis/lock")
    public void test(){
        String id = UUID.randomUUID().toString();
        try{
            redisLockService.lock(id,20);
        }finally {
            redisLockService.unlock(id);
        }
    }

}
