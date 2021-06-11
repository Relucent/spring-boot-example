package yyl.springboot.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import yyl.springboot.model.MessagePayload;
import yyl.springboot.service.MessagingService;

/**
 * 消息处理
 */
@Controller
public class MessagingController {

    @Autowired
    private MessagingService messagingService;

    /**
     * 接收客户端的消息
     * @param payload 消息载体
     * @param accessor 协议头访问器
     */
    @MessageMapping("/~")
    public void send(@Payload MessagePayload payload, StompHeaderAccessor accessor) {
        Principal principal = accessor.getUser();
        String sessionId = accessor.getSessionId();
        System.out.println("send/~ sessionId:" + sessionId + ", principal:" + principal + "\n");
        messagingService.send(payload);
    }
}
