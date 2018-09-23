package com.example.demo.topic;


import com.example.demo.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * Created by maofujiang on 2018/9/12.
 */
public class Send {

    public static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtil.getConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String message = "id=1001";
        channel.basicPublish(EXCHANGE_NAME, "item.update", null, message.getBytes());
        System.out.println("send ["+message+"]");

        channel.close();
        connection.close();
    }
}