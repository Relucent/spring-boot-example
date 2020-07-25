package yyl.springboot.server;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yyl.springboot.context.CustomSpringConfigurator;
import yyl.springboot.session.SessionPools;

/**
 * <h3>WebSocket服务器端</h3><br>
 * 默认ServerEndpoint是多例模式，使用自定义的装配器，使其被Spring容器托管成为单例模式<br>
 * @see CustomSpringConfigurator
 */
@ServerEndpoint(value = "/websocket/hello/{uid}", configurator = CustomSpringConfigurator.class)
@Component
public class WebSocketHelloServer {

	@Autowired
	private SessionPools sessionPools;

	/**
	 * 构造
	 */
	public WebSocketHelloServer() {
		System.out.println("WebSocketHelloServer()");
	}

	/**
	 * 建立连接成功调用
	 * @param session Socket会话
	 * @param uid 用户身份标识
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam(value = "uid") String uid) {
		System.out.println("Open Session Id:" + session.getId());
		sessionPools.put(session, uid);
		sendMessage(session, "Welcome {" + uid + "}");
	}

	/**
	 * 收到客户端信息
	 * @param message 消息内容
	 * @param session Socket会话
	 * @param sid 用户身份标识
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("Client Message:" + message);
		String uid = sessionPools.getUid(session);
		sendMessage(uid + "：" + message);
	}

	/**
	 * 出现异常时调用被调用
	 * @param session Socket会话
	 * @param throwable 异常
	 */
	@OnError
	public void onError(Session session, Throwable throwable) {
		throwable.printStackTrace();
	}

	/**
	 * 关闭连接时调用
	 * @param session Socket会话
	 */
	@OnClose
	public void onClose(Session session) {
		sessionPools.remove(session);
	}

	/**
	 * 群发消息
	 * @param message 消息内容
	 */
	private void sendMessage(String message) {
		for (Session session : sessionPools.values()) {
			sendMessage(session, message);
		}
	}

	/**
	 * 发送消息
	 * @param session Socket会话
	 * @param message 消息内容
	 */
	private void sendMessage(Session session, String message) {
		if (session != null) {
			synchronized (session) {
				if (session.isOpen()) {
					try {
						session.getBasicRemote().sendText(message);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
