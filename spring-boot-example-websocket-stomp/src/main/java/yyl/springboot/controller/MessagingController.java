package yyl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
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
     * @param token 消息票据(header: x-token)
     */
    @MessageMapping("/~")
    public void accept(@Payload MessagePayload payload, @Header("x-token") String token) {
        messagingService.send(payload);
    }
}
