package yyl.springboot.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;

@EnableTransactionManagement
@Configuration
@MapperScan(basePackages = "yyl.springboot")
public class MybatisPlusConfiguration {
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor interceptor = new PaginationInterceptor();
		// 设置最大单页限制数量，默认 500 条，-1 不受限制
		interceptor.setLimit(500);
		// 开启 count 的 join 优化,只针对部分 left join
		interceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
		return interceptor;
	}
}
