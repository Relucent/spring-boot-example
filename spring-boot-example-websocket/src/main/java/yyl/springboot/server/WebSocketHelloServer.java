package yyl.springboot.server;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint("/websocket/hello/{sid}")
@Component
public class WebSocketHelloServer {

	private static Map<String, Session> sessionPools = new ConcurrentHashMap<>();

	// 建立连接成功调用
	@OnOpen
	public void onOpen(Session session, @PathParam(value = "sid") String sid) {
		System.out.println("Open Session Id:" + session.getId());
		sessionPools.put(sid, session);
		try {
			sendMessage(session, "欢迎{" + sid + "}加入连接！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 收到客户端信息
	@OnMessage
	public void onMessage(String message, Session session, @PathParam(value = "sid") String sid) throws IOException {
		System.out.println("Client Message:" + message);
		sendMessage(sid + "：" + message);
	}

	// 错误时调用
	@OnError
	public void onError(Session session, Throwable throwable) {
		System.out.println("发生错误");
		throwable.printStackTrace();
	}

	// 关闭连接时调用
	@OnClose
	public void onClose(@PathParam(value = "sid") String sid) {
		sessionPools.remove(sid);
	}

	// 群发消息
	private void sendMessage(String message) throws IOException {
		for (Session session : sessionPools.values()) {
			try {
				sendMessage(session, message);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}

	// 发送消息
	private void sendMessage(Session session, String message) throws IOException {
		if (session != null) {
			synchronized (session) {
				if (session.isOpen()) {
					session.getBasicRemote().sendText(message);
				}
			}
		}
	}
}
