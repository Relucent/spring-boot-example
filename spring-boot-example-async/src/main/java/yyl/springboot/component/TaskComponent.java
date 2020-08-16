package yyl.springboot.component;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class TaskComponent {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 模拟异步任务
     * @param millis 任务执行时间（单位毫秒）
     * @return 执行结果（Future）
     */
    @Async
    public Future<Boolean> asyncTask(long millis) throws InterruptedException {
        doTask("asyncTask", millis);
        return new AsyncResult<>(Boolean.TRUE);
    }

    /**
     * 模拟同步任务
     * @param millis 任务执行时间（单位毫秒）
     * @return 执行结果
     */
    public void task(long millis) throws InterruptedException {
        doTask("task", millis);
    }

    private void doTask(String taskName, long millis) throws InterruptedException {
        logger.info("Start The Task: {}, thread: {}", taskName, Thread.currentThread().getName());
        Thread.sleep(millis);
        logger.info("Finish The Task: {}, thread: {}", taskName, Thread.currentThread().getName());
    }
}
