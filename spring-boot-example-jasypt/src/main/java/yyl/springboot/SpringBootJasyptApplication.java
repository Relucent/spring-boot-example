package yyl.springboot;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class SpringBootJasyptApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootJasyptApplication.class);

    @Value("${custom.value}")
    private String value;

    @PostConstruct
    void construct() {
        System.out.println(value);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJasyptApplication.class, args);
        LOGGER.info("[Startup Success]");
    }
}
