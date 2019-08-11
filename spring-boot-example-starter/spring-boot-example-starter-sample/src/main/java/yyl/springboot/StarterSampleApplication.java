package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(StarterSampleApplication.class, args);
        System.out.println("startup success");
    }
}
