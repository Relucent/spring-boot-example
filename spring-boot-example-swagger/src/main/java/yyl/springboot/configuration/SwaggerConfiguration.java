package yyl.springboot.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    // # swagger-ui/index.html

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)//
                .apiInfo(apiInfo())//
                .select()//
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//
                .paths(PathSelectors.any())//
                .build()//
                .globalRequestParameters(globalRequestParameters());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()//
                .title("APIs")//
                .version("1.0")//
                .build();
    }

    private List<RequestParameter> globalRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()//
                .name("Access-Token")//
                .description("身份令牌")//
                .in(ParameterType.HEADER)//
                .required(false).build());
        return parameters;
    }
}