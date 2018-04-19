
package yyl.springboot.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import yyl.springboot.model.Message;

@Repository
public class MessageService {

	private final ConcurrentMap<Long, Message> store = new ConcurrentHashMap<>();
	private final AtomicLong idGenerator = new AtomicLong();

	public Iterable<Message> findAll() {
		return this.store.values();
	}

	public Message save(Message message) {
		Long id = message.getId();
		if (id == null) {
			id = idGenerator.incrementAndGet();
			message.setId(id);
		}
		this.store.put(id, message);
		return message;
	}

	public Message getById(Long id) {
		return this.store.get(id);
	}

	public void remove(Long id) {
		this.store.remove(id);
	}

}
