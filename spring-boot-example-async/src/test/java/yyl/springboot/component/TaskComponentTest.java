package yyl.springboot.component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskComponentTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TaskComponent component;

    /**
     * 测试异步任务
     */
    @Test
    public void asyncTaskTest() throws InterruptedException, ExecutionException {
        long usetime = 2 * 1000;
        long start = System.currentTimeMillis();
        Future<Boolean> future = component.asyncTask(usetime);
        if ((System.currentTimeMillis() - start) >= usetime) {
            Assert.fail("The task is not executed asynchronously");
        }
        logger.info("Task Return Future, total time: {}ms", (System.currentTimeMillis() - start));
        logger.info("Future get() => {} ", future.get());
        logger.info("Asynchronous tasks are finished, total time: {}", (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * 测试同步任务
     */
    @Test
    public void taskTest() throws InterruptedException {
        long usetime = 2 * 1000;
        long start = System.currentTimeMillis();
        component.task(usetime);
        if ((System.currentTimeMillis() - start) < usetime) {
            Assert.fail("The task is not synchronized");
        }
        logger.info("Asynchronous tasks are finished, total time: {}", (System.currentTimeMillis() - start) + "ms");
    }
}
