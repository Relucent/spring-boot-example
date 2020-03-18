package yyl.springboot.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 应用全局参数
 */
@Component
@ConfigurationProperties(prefix = "global")
@Data
public class GlobalProperties {

	/** 项目信息 */
	@NestedConfigurationProperty
	private RocketmqConfig rocketmq = new RocketmqConfig();

	@Data
	public class RocketmqConfig {
		/**
		 * Name Server 地址，如果集群部署多个用 分号(;)隔开
		 */
		public String nameServer = "127.0.0.1:9876";
		/**
		 * 主题名称，主题在一在服务器设置好<br>
		 * 如果没有创建，生产者往该主题发送消息会报找不到topic错误）， 可以在启动Broker时候指定autoCreateTopicEnable=true参数来允许自动创建。
		 */
		public String topic = "hello";
	}
}
