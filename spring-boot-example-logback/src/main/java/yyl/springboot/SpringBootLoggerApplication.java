package yyl.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoggerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootLoggerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLoggerApplication.class, args);
        LOGGER.info("startup success");
    }
}
