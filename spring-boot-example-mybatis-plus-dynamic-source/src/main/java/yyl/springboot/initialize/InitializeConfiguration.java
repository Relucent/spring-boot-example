package yyl.springboot.initialize;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import yyl.springboot.initialize.component.Schema1Component;
import yyl.springboot.initialize.component.Schema2Component;

@Configuration
public class InitializeConfiguration {

    @Autowired
    public Schema1Component schema1Component;
    @Autowired
    public Schema2Component schema2Component;

    @PostConstruct
    protected void initialize() {
        schema1Component.initialize();
        schema2Component.initialize();
    }
}
