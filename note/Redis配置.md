### REDIS 配置  
属性 | 说明  
------------ | -------------  
spring.redis.database | Redis数据库索引，默认为0
spring.redis.host | Redis服务器地址 ，例如localhost 
spring.redis.port | Redis服务器连接端口，默认 6379
spring.redis.password | Redis服务器连接密码，默认为空
spring.redis.pool.max-active | 连接池最大连接数，使用负值表示没有限制(8)
spring.redis.pool.max-wait | 连接池最大阻塞等待时间，使用负值表示没有限制 (-1)
spring.redis.pool.max-idle | 连接池中的最大空闲连接 (8)
spring.redis.pool.min-idle | 连接池中的最小空闲连接 (0)
spring.redis.timeout | 连接超时时间，单位毫秒 (默认0永不超时)