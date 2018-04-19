package yyl.springboot.configuration;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import yyl.springboot.security.ShiroRealm;

@Configuration
public class ShiroConfiguration {

	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

		System.out.println("ShiroConfiguration.shirFilter()");

		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		// 拦截规则定义(按照顺序判断)
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

		// | 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/static/**", "anon");

		// | 配置退出过滤器(具体的退出代码_Shiro已经替我们实现了)
		filterChainDefinitionMap.put("/logout", "logout");

		// | authc: 需要认证通过
		// | anon : 允许匿名访问
		filterChainDefinitionMap.put("/**", "authc");

		// | 登录页面(默认为"/login.jsp"页面)
		shiroFilterFactoryBean.setLoginUrl("/login");

		// | 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/index");

		// | 未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了 ）
	 */
	@Bean
	public CredentialsMatcher credentialsMatcher() {
		return new SimpleCredentialsMatcher();
	}

	@Bean
	public ShiroRealm myShiroRealm() {
		ShiroRealm myShiroRealm = new ShiroRealm();
		myShiroRealm.setCredentialsMatcher(credentialsMatcher());
		return myShiroRealm;
	}

	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		return securityManager;
	}

	/**
	 * 开启_Shiro AoP 注解支持 使用代理方式;所以需要开启代码支持;
	 */
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
		return authorizationAttributeSourceAdvisor;
	}

	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.setProperty("UnauthorizedException", "403");
		r.setExceptionMappings(mappings); // None by default
		r.setDefaultErrorView("error"); // No default
		r.setExceptionAttribute("ex"); // Default is "exception"
		return r;
	}
}