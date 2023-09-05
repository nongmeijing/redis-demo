package com.example.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.ArrayList;

@SpringBootTest
class RedisDemoApplicationTests {


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void redis(){
        stringRedisTemplate.opsForValue().set("redis_test","successful");
    }

    @Test
    void lua(){
        //lua脚本语言
        String str="return redis.call('get','myTest');";
        DefaultRedisScript<String> script=new DefaultRedisScript<>(str);
        script.setResultType(String.class);
        String result=stringRedisTemplate.execute(script,new ArrayList<>());
        System.out.println(result);
    }

    @Test
    void lu2(){
        String str="return redis.call('get','myTest');";
        DefaultRedisScript<String> script=new DefaultRedisScript<>(str);
        script.setResultType(String.class);
        String result=stringRedisTemplate.execute(script,new ArrayList<>());
        System.out.println(result);
    }

    @Test
    void msg(){
        stringRedisTemplate.convertAndSend(RedisMessageListener.TOPTIC,"test-msg");
    }

    @Test
    void run(){
        while (true){

        }
    }

}
