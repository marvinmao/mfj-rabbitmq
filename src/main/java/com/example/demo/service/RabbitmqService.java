package com.example.demo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * User: maofujiang
 * Date: 2018/9/18
 */
public interface RabbitmqService {

    void rabbitTest();

    void queryDb();

}
