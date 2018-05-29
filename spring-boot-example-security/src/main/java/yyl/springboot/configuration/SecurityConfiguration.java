package yyl.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import yyl.springboot.security.UserDetailsServiceImpl;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());;
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
                // 指定登录失败后跳转到/login?error页面
                .failureUrl("/login?error").permitAll()
                // 指定登录成功后跳转到/index页面
                .defaultSuccessUrl("/index")
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
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
