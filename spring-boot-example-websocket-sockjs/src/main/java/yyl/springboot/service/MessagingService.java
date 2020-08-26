package yyl.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 发送消息
     * @param destination 目的地
     * @param payload 消息载荷
     */
    public void send(String destination, Object payload) {
        messagingTemplate.convertAndSend(destination, payload);
    }
}
