package com.example.demo.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: maofujiang
 * Date: 2018/9/17
 */
public class SpringMain {

    public static void main(final String... args) throws InterruptedException {

        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/rabbitmq-content.xml");

        // rabbitmq模板
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        // 发送消息
        template.convertAndSend("hello word");

        Thread.sleep(1000);
        // 容器销毁
        ctx.destroy();
    }
}
