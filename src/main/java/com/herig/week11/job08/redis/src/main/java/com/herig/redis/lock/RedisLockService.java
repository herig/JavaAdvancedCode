package com.herig.redis.lock;

import java.io.UnsupportedEncodingException;

public interface RedisLockService {

    boolean lock(String id, int expireTime);

    boolean unlock(String id);

}
