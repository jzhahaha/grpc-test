//package com.grpc.server.dao.impl.redis;
//
//import com.grpc.server.dao.BaseRedis;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class Test1Redis extends BaseRedis<String> {
//
//
//
//    private static final String PREXI = "zj.com:test1:%s";
//
//    public void storeTest1(String key, String value){
//        storeValue(genKey(key), value);
//    }
//
//    public String getTest1(String key){
//        return getValue(genKey(key));
//    }
//
//    private String genKey(String key){
//        return String.format(PREXI, key);
//    }
//
//}
////