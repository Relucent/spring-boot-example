package yyl.springboot.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yyl.springboot.common.GlobalProperties;
import yyl.springboot.common.GlobalProperties.RocketmqConfig;

@Component
public class ProducerComponent {

	/** 生产者组名称 */
	public static final String PRODUCER_GROUP = "test_producer";
	/** 生产者实体对象 */
	private DefaultMQProducer producer;
	/** 主题名称 */
	private String topic;

	@Autowired
	private GlobalProperties globalProperties;

	public ProducerComponent() {
		System.out.println("Producer()");
	}

	/**
	 * 发送消息
	 * @param msg 消息内容
	 */
	public void send(String msg) {
		try {
			Message message = new Message(topic, "testtag", msg.getBytes());
			producer.send(message);
		} catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
			e.printStackTrace();
			if (e instanceof InterruptedException) {
				Thread.currentThread().interrupt();
			}
		}
	}

	@PostConstruct
	protected void initialize() throws Exception {
		RocketmqConfig cfg = globalProperties.getRocketmq();

		// 主题名称
		topic = cfg.getTopic();
		// 示例生产者
		producer = new DefaultMQProducer(PRODUCER_GROUP);
		// 不开启VIP通道 开通口端口会减2
		producer.setVipChannelEnabled(false);
		// 绑定name server
		producer.setNamesrvAddr(cfg.getNameServer());
		// 使用之前必须要调用一次，只能初始化一次
		producer.start();
		// 打印日志
		System.out.println("producer.start()");
	}

	@PreDestroy
	public void shutdown() {
		producer.shutdown();
	}
}