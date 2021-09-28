package yyl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class DockerApplication {

    @RequestMapping("/")
    public String hello() {
        return "hello, world";
    }

    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
        System.out.println("startup success");
    }
}
