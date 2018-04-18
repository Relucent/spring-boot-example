package yyl.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class Scheduler2Task {

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private final AtomicLong count = new AtomicLong();

	@Scheduled(cron = "*/5 * * * * ?")
	public void execute() {
		System.out.println(dateFormat.format(new Date()) + ":" + count.incrementAndGet());
	}

}
