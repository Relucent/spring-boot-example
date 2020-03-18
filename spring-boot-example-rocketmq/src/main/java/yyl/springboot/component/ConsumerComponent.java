package yyl.springboot.component;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import yyl.springboot.common.GlobalProperties;
import yyl.springboot.common.GlobalProperties.RocketmqConfig;

@Component
@DependsOn("producerComponent")
public class ConsumerComponent {

	/** 消费者组 */
	public static final String CONSUMER_GROUP = "test_consumer";
	/** 消费者实体对象 */
	private DefaultMQPushConsumer consumer;

	@Autowired
	private GlobalProperties globalProperties;

	public ConsumerComponent() {
		System.out.println("Consumer()");
	}

	/**
	 * 消费消息
	 * @param msgs 消息列表
	 * @param context 消费者上下文
	 * @return 消费状态
	 */
	private ConsumeConcurrentlyStatus consumeMessage(final List<MessageExt> msgs, final ConsumeConcurrentlyContext context) {
		// msgs中只收集同一个topic，同一个tag，并且key相同的message，会把不同的消息分别放置到不同的队列中
		try {
			for (Message msg : msgs) {
				// 消费者获取消息 这里只输出 不做后面逻辑处理
				String body = new String(msg.getBody(), "utf-8");
				System.out.println("Consumer-获取消息-主题topic为=" + msg.getTopic() + ", 消费消息为=" + body);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			// 失败消费，以后尝试消费
			return ConsumeConcurrentlyStatus.RECONSUME_LATER;
		}
		// 消费成功
		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}

	@PostConstruct
	protected void initialize() throws Exception {
		// 获得配置信息
		RocketmqConfig cfg = globalProperties.getRocketmq();
		// 主题名称
		String topic = cfg.getTopic();

		// 示例消费者
		consumer = new DefaultMQPushConsumer(CONSUMER_GROUP);
		// 绑定name server
		consumer.setNamesrvAddr(cfg.getNameServer());
		// 消费模式:一个新的订阅组第一次启动从队列的最后位置开始消费 后续再启动接着上次消费的进度开始消费
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
		// 订阅主题和 标签（ * 代表所有标签)下信息
		consumer.subscribe(topic, "*");
		// //注册消费的监听 并在此监听中消费信息，并返回消费的状态信息
		consumer.registerMessageListener((MessageListenerConcurrently) this::consumeMessage);
		// 启动消费者
		consumer.start();
		// 打印日志
		System.out.println("consumer.start()");
	}
}
