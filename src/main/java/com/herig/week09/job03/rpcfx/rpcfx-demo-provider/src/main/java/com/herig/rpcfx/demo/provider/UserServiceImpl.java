package com.herig.rpcfx.demo.provider;


import com.herig.rpcfx.demo.api.User;
import com.herig.rpcfx.demo.api.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }
}
