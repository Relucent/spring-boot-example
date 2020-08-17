package yyl.springboot.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloComponent implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("start");
        for (int i = 5; i >= 0; i--) {
            Thread.sleep(1000);
            System.out.println("count down " + i);
        }
        System.out.println("complete");
    }
}
