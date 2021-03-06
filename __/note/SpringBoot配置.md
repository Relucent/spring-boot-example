## SpringBoot 配置文件说明  

默认配置文件：application.yml 或 application.properties  
配置文件中属性允许使用占位符，例如 ${port:80}，运行时使用 Java -jar app.jar --server.port=8081 方式来传递参数  

### 配置说明

配置 | 说明  
------------ | -------------
server.port | 服务端口，默认为8080
server.port | 最大超时时间(分钟)，默认为30
server.address | 该服务绑定IP地址，启动服务器时如本机不是该IP地址则抛出异常启动失败，只有特殊需求的情况下才配置
server.tomcat.max-threads | tomcat最大线程数，默认为200
server.tomcat.uri-encoding | tomcat编码，默认为UTF-8
server.tomcat.basedir | 存放Tomcat的日志、Dump等文件的临时文件夹，默认为系统的tmp文件夹(如：C:\Users\Admin\AppData\Local\Temp)
server.tomcat.access-log-enabled | Tomcat-Access日志是否开启，true|false
server.tomcat.access-log-pattern | Tomcat-Access日志格式
server.tomcat.accesslog.directory | Tomcat-Access日志目录，默认在basedir/logs
logging.path | 日志文件目录，；例如 D:/spring-boot-example/logs
logging.file | 日志文件名称，默认为spring.log
logging.config | 日志配置文件，默认为classpath:logback.xml (logback的配置文件)
logging.level.* | 日志级别 (TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF)
logging.level.root | root日志的级别
logging.level.org.springframework | org.springframework的日志级别，默认是DEBUG