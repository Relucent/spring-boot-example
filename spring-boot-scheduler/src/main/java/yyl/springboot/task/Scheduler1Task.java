package yyl.springboot.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler1Task {

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private final AtomicLong count = new AtomicLong();

	@Scheduled(fixedDelay = 5000)
	public void execute() {
		System.out.println(dateFormat.format(new Date()) + ":" + count.incrementAndGet());
	}

}
