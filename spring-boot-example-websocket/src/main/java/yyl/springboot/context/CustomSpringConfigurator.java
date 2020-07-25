package yyl.springboot.context;

import javax.websocket.server.ServerEndpointConfig;

/**
 * <h3>自定义配置器</h3><br>
 * @see org.springframework.web.socket.server.standard.SpringConfigurator
 */
public class CustomSpringConfigurator extends ServerEndpointConfig.Configurator {
	public <T extends Object> T getEndpointInstance(Class<T> requiredType) {
		return SpringContextHolder.getBean(requiredType);
	}
}
