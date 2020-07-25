package yyl.springboot.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

	// ==============================Fields===========================================
	private static volatile ApplicationContext CONTEXT;

	// ==============================Methods==========================================
	public static <T> T getBean(Class<T> requiredType) throws BeansException {
		return CONTEXT.getBean(requiredType);
	}

	public static <T> T createBean(Class<T> beanClass) {
		return CONTEXT.getAutowireCapableBeanFactory().createBean(beanClass);
	}

	// ==============================OverrideMethods==================================
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		CONTEXT = applicationContext;
	}

	@Override
	public void destroy() throws Exception {
		CONTEXT = null;
	}
}
