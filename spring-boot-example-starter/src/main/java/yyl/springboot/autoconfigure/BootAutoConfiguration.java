package yyl.springboot.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import yyl.springboot.component.HelloComponent;

/**
 * 自动配置类
 */
@Configuration
public class BootAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public HelloComponent helloComponent() {
        return new HelloComponent();
    }
}
