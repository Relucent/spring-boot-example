package yyl.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import yyl.springboot.service.MessagingService;

/**
 * 测试组件，每隔1秒发送一条消息
 */
@Configuration
@EnableScheduling
public class SendExample {

    @Autowired
    MessagingService messagingService;

    // 测试，开启一个线程每隔1秒发送一条消息
    @Scheduled(fixedDelay = 1000L)
    public void scheduled() {
        messagingService.send("/topic/time", "DATETIME:" + System.currentTimeMillis());
    }

}
