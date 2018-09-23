package com.example.demo.service.impl;

import com.example.demo.service.RabbitmqService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: maofujiang
 * Date: 2018/9/18
 */
@Service
public class RabbitmqServiceImpl implements RabbitmqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AccAlarmEventMapper accAlarmEventMapper;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public void rabbitTest() {
        sendMsg("1001", "update");
    }

    @Override
    public void queryDb() {
        AccAlarmEventCriteria example=new AccAlarmEventCriteria();
        AccAlarmEventCriteria.Criteria criteria = example.createCriteria();
        criteria.andAlarmTypeDescIsNull();
        List<AccAlarmEvent> accAlarmEvents = accAlarmEventMapper.selectByExample(example);
        long countByExample = accAlarmEventMapper.countByExample(example);
    }

    /**
     * 发送MQ消息通知其他系统
     * */
    private void sendMsg(String itemId, String type) {
        try {
            Map<String, Object> msg = new HashMap<>();
            msg.put("itemId", itemId);
            msg.put("type", type);
            msg.put("date", System.currentTimeMillis());
            this.rabbitTemplate.convertAndSend("item.update", MAPPER.writeValueAsString(msg));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
