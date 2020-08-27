package yyl.springboot.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import yyl.springboot.model.MessagePayload;

/**
 * 消息处理
 */
@Controller
public class MessagingController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 接收客户端的消息
     * @param payload 消息载体
     * @param token 消息票据(header: x-token)
     */
    @MessageMapping("/topic/hello-send")
    public void send(@Payload MessagePayload payload, @Header("x-token") String token) {
        String message = payload.getMessage();
        System.out.println("token=" + token + ",message=" + message);
        messagingTemplate.convertAndSend("/topic/hello", "[" + token + "]: " + message);
    }

    /**
     * [测试]每隔5秒向客户端发送一条消息
     */
    @Scheduled(fixedDelay = 5 * 1000L)
    protected void scheduleSend() {
        String payload = "DATETIME:" + new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:dd").format(System.currentTimeMillis());
        messagingTemplate.convertAndSend("/topic/hello", payload);
    }
}
