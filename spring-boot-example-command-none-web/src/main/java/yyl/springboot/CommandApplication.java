package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
        System.out.println("startup success");
    }
}
