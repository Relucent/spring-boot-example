# Kafka  
Kafka 是一种高吞吐量 的分布式发布订阅消息系统  
由Apache软件基金会开发的一个开源流处理平台，由Scala和Java编写  

## 安装

1. 下载地址  
https://kafka.apache.org/downloads  

2. 解压  

	tar -zxvf kafka_2.11-1.1.0.tgz
	cd /usr/local/kafka_2.11-1.1.0/

3. 查看 kafka-server 配置文件

	vi /usr/local/kafka/config/server.properties

	broker.id=1

4. 启动 ZK

	bin/zookeeper-server-start.sh -daemon config/zookeeper.properties

5. 启动 Kafka

	bin/kafka-server-start.sh  config/server.properties

## 测试

1. 创建 topic  
使用 kafka-topics.sh 创建单分区单副本的 topic test：  

	bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

2. 查看 topic 列表：  

	bin/kafka-topics.sh --list --zookeeper localhost:2181

3. 产生消息 (需要打开新窗口)
使用 kafka-console-producer.sh 发送消息：  

	bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test

4. 消费消息，使用 kafka-console-consumer.sh 接收消息并在终端打印：

	bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic test --from-beginning
	
5. 查看描述 topics 信息

	bin/kafka-topics.sh --describe --zookeeper localhost:2181 --topic test

## 备注
修改  hosts  
C:\Windows\System32\drivers\etc\hosts  

	192.168.1.1 KAFKA_HOST_001

