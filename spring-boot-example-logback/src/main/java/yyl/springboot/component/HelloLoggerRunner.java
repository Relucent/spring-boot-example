package yyl.springboot.component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloLoggerRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.debug("hello slf4j {}", DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
    }
}