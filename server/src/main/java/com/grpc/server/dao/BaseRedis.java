//package com.grpc.server.dao;
//
//import org.springframework.data.redis.core.*;
//
//import javax.annotation.Resource;
//import java.util.concurrent.TimeUnit;
//
//public abstract class BaseRedis <T> {
//
//    @Resource(name = "redisTemplate")
//    private RedisTemplate<String, String> redisTemplate;
//
//    private ValueOperations<String, String> opsForString(){ return redisTemplate.opsForValue(); }
//    private ListOperations<String, String> opsForList(){ return redisTemplate.opsForList(); }
//    private HashOperations<String, String, String> opsForHash(){ return redisTemplate.opsForHash(); }
//    private ZSetOperations<String, String> opsForZSet(){ return redisTemplate.opsForZSet(); }
//
//
//    private static final long EXPIRE = 2*24*3600;
////
//
//    public void storeValue(String key, String value ){
//        opsForString().set(key, value);
//        redisTemplate.expire(key, EXPIRE, TimeUnit.SECONDS);
//    }
//
//    public String getValue(String key){
//        return opsForString().get(key);
//    }
//
//
//}
