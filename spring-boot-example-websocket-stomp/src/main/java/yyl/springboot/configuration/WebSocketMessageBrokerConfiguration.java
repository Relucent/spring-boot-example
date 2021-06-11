package yyl.springboot.configuration;

import java.security.Principal;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.Cookie;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import org.springframework.web.util.WebUtils;

import yyl.springboot.model.AuthenticatedUser;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketMessageBrokerConfiguration implements WebSocketMessageBrokerConfigurer {

    private static final String ACCESS_TOKEN_HEADER = "Access-Token";

    private static final String PRINCIPAL_ATTRIBUTE = "@principal";

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")//
                .addInterceptors(new HandshakeInterceptor() {
                    @Override
                    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                            Map<String, Object> attributes) throws Exception {

                        String token = Optional.ofNullable(//
                                WebUtils.getCookie(((ServletServerHttpRequest) request).getServletRequest(), ACCESS_TOKEN_HEADER)//
                        ).map(Cookie::getValue).orElse(null);

                        if (token == null) {
                            return true;
                        }

                        attributes.put(PRINCIPAL_ATTRIBUTE, new AuthenticatedUser(token));
                        return true;
                    }

                    @Override
                    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                            Exception exception) {

                    }
                })//
                .setHandshakeHandler(new DefaultHandshakeHandler() {
                    @Override
                    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
                        return (Principal) attributes.get(PRINCIPAL_ATTRIBUTE);
                    }
                })//
                .setAllowedOrigins("*")//
                .withSockJS();
    }

    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
                StompCommand command = accessor.getCommand();
                String sessionId = accessor.getSessionId();
                String destination = accessor.getDestination();
                Principal principal = accessor.getUser();
                System.out.println(">>>" + System.currentTimeMillis());
                System.out.println("command: " + command);
                System.out.println("sessionId: " + sessionId);
                System.out.println("destination: " + destination);
                System.out.println("principal: " + principal.getName());
                System.out.println();
                return message;
            }
        });
    }
}