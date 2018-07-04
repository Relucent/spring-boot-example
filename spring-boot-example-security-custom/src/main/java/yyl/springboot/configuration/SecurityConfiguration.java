package yyl.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import yyl.springboot.security.CustomAuthenticationFailureHandler;
import yyl.springboot.security.CustomAuthenticationFilter;
import yyl.springboot.security.CustomAuthenticationProvider;
import yyl.springboot.security.CustomAuthenticationSuccessHandler;


// |如果想支持@PreAuthorize,可以添加 @EnableGlobalMethodSecurity(prePostEnabled = true) 注解

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 自定义 Provider
        auth.authenticationProvider(customAuthenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // http.authorizeRequests()方法有多个子节点，每个MACHER按照他们的声明顺序执行
        http.authorizeRequests()
                // 任何用户都可以访问以"/s/**","/login" URL。
                .antMatchers("/s/**", "/login").permitAll()
                // 同时具有 ADMIN和 PAGE1 角色的用户才可以访问 "/page1"
                .antMatchers("/page1").access("hasRole('ADMIN') and hasRole('ROOT')")
                // "/page2" 的访问使用自定义的授权策略
                .antMatchers("/page2").access("@securityInterceptor.check(authentication,request)")
                // 尚未匹配的任何URL都要求用户进行身份验证
                .anyRequest().authenticated()
                // 配置登录
                .and().formLogin()
                // 设置登录URL为/login
                .loginPage("/login").permitAll()

                // 指定登录失败后跳转到/login?error页面 |
                .failureUrl("/login?error")
                // 指定登录成功后跳转到/index页面 | 与successHandler方法冲突 |
                .defaultSuccessUrl("/index")

                // 备注：
                // 这两个方法配置的类会注入到UsernamePasswordAuthenticationFilter 而非 customAuthenticationFilter
                // 所以successHandler和failureHandler此处配置是无效的
                // 解决方法是直接将 successHandler和failureHandler 添加给customAuthenticationFilter


                // 配置登录成功的处理器 和 登录失败的处理器
                .successHandler(customAuthenticationSuccessHandler())
                .failureHandler(customAuthenticationFailureHandler())

                // 配置登出
                .and().logout()
                // 指定登出的URL (默认logout)
                // 添加CSRF将更新LogoutFilter以仅使用HTTP POST, CSRF令牌使恶意用户无法伪造你的logout请求
                // .logoutUrl("/logout").permitAll()
                // 使用GET请求的方式
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // 指定登出成功之后跳转的URL (默认登录页面)
                .logoutSuccessUrl("/login").permitAll()
                // | 关闭CSRF
                // | .and().csrf().disable();
                // 开启cookie储存用户信息，并设置有效期为1天，指定cookie中的密钥
                .and().rememberMe().tokenValiditySeconds(24 * 60 * 60).key("KEY");


        // 加入自定义UsernamePasswordAuthenticationFilter替代原有Filter
        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }



    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {

        CustomAuthenticationFilter customFilter =
                new CustomAuthenticationFilter(authenticationManager());

        // 配置成功和失败的处理器
        customFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler());
        customFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler());

        return customFilter;
    }

    @Bean
    public CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    public CustomAuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
