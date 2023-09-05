package com.example.redisdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

@Configuration
public class RedisMessageListener implements MessageListener{
    public static final String TOPTIC="message-topic";
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String msg=new String(message.getChannel());
        String msgContext=new String(message.getBody());
        System.out.println("测试文字："+msg);
        System.out.println(msgContext);
    }
}
