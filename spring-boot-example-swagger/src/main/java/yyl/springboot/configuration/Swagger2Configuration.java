package yyl.springboot.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

	// swagger-ui.html

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.apiInfo(apiInfo())//
				.select()//
				.apis(RequestHandlerSelectors.basePackage("yyl.springboot"))//
				.paths(PathSelectors.any()).build()//
				.globalOperationParameters(setHeaderToken());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("APIs")//
				.version("1.0")//
				.build();
	}

	private List<Parameter> setHeaderToken() {
		List<Parameter> params = new ArrayList<>();
		Parameter tokenParam = new ParameterBuilder()//
				.name("token").description("身份令牌")//
				.modelRef(new ModelRef("string"))//
				.parameterType("header")//
				.required(false).build();
		params.add(tokenParam);
		return params;
	}
}