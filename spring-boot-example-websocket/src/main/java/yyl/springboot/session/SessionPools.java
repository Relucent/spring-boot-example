package yyl.springboot.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.Session;

import org.springframework.stereotype.Component;

/**
 * 会话池
 */
@Component
public class SessionPools {

	/** Session池 */
	private final Map<String, SessionEntry> sessionStore = new HashMap<>();
	/** UID到SessionId的映射 */
	private final Map<String, Set<String>> uidSessionIdsMap = new HashMap<>();
	/** 锁对象 */
	private final Object monitor = new byte[0];

	/**
	 * 注册会话
	 * @param session WebSocket会话
	 * @param uid 绑定的用户ID
	 */
	public void put(final Session session, final String uid) {
		SessionEntry element = new SessionEntry(session, uid);
		synchronized (monitor) {
			String sessionId = session.getId();
			sessionStore.put(sessionId, element);
			Set<String> sessionIdSet = uidSessionIdsMap.get(uid);
			if (sessionIdSet == null) {
				uidSessionIdsMap.put(uid, sessionIdSet = new HashSet<>());
			}
			sessionIdSet.add(sessionId);
		}
	}

	/**
	 * 移除会话
	 * @param session 移除的Socket会话
	 */
	public void remove(final Session session) {
		String sessionId = session.getId();
		synchronized (monitor) {
			SessionEntry entry = sessionStore.remove(sessionId);
			if (entry != null) {
				Set<String> sessionIdSet = uidSessionIdsMap.get(entry.uid);
				if (sessionIdSet != null) {
					sessionIdSet.remove(sessionId);
					if (sessionIdSet.isEmpty()) {
						uidSessionIdsMap.remove(entry.uid);
					}
				}
			}
		}
	}

	/**
	 * 获得全部会话
	 * @return 全部会话
	 */
	public Collection<Session> values() {
		final List<Session> sessions = new ArrayList<>();
		synchronized (monitor) {
			for (SessionEntry entry : sessionStore.values()) {
				sessions.add(entry.session);
			}
		}
		return sessions;
	}

	/**
	 * 根据用户查询WebSocket会话
	 * @param uid 用户ID
	 * @return WebSocket会话列表
	 */
	public List<Session> findByUid(final String uid) {
		final List<Session> sessions = new ArrayList<>();
		synchronized (monitor) {
			for (String sessionId : uidSessionIdsMap.get(uid)) {
				SessionEntry entry = sessionStore.get(sessionId);
				if (entry != null) {
					sessions.add(entry.session);
				}
			}
		}
		return sessions;
	}

	/**
	 * 根据WebSocket会话查询用户
	 * @param session WebSocket会话列表
	 * @return 用户ID
	 */
	public String getUid(final Session session) {
		synchronized (monitor) {
			SessionEntry entry = sessionStore.get(session.getId());
			return entry == null ? null : entry.uid;
		}
	}

	/** 会话项 */
	@SuppressWarnings("serial")
	public class SessionEntry implements Serializable {

		/** Socket会话 */
		private final Session session;
		/** 用户ID */
		private final String uid;

		/**
		 * 构造函数（在线会话）
		 * @param session Socket会话
		 * @param uid 用户ID
		 */
		public SessionEntry(Session session, String uid) {
			this.session = session;
			this.uid = uid;
		}
	}
}
