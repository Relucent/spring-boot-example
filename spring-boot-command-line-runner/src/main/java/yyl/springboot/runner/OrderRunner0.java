package yyl.springboot.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderRunner0 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("The Runner-0 start to initialize ...");
    }
}