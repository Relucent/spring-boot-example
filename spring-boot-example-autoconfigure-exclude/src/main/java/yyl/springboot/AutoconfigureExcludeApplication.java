package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AutoconfigureExcludeApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoconfigureExcludeApplication.class, args);
        System.out.println("startup success");
    }
}
