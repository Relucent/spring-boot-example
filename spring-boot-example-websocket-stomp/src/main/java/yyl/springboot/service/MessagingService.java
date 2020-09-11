package yyl.springboot.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import yyl.springboot.model.MessagePayload;

@Service
public class MessagingService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 发送消息
     * @param payload 消息载荷
     */
    public void send(MessagePayload payload) {
        String to = payload.getTo();
        String topic = payload.getTopic();
        topic = topic.startsWith("/") ? topic : "/" + topic;
        if ("*".equals(to)) {
            messagingTemplate.convertAndSend(topic, payload);
        } else {
            messagingTemplate.convertAndSendToUser(to, topic, payload);
        }
    }

    /**
     * [测试]每隔5秒向客户端发送一条消息
     */
    @Scheduled(fixedDelay = 5 * 1000L)
    protected void scheduleSend() {
        String payload = "DATETIME:" + new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:dd").format(System.currentTimeMillis());
        messagingTemplate.convertAndSend("/hello", payload);
    }
}
