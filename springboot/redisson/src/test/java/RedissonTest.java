import com.redisson.RedissonApplication;
import com.redisson.config.RedissonConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-30 15:25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = RedissonApplication.class)
public class RedissonTest {

    @Autowired
    private RedissonConfig redissonConfig;

    @Test
    public void doTest() throws InterruptedException {
        RedissonClient client = redissonConfig.redissonSingleClient();
        RLock fairLock = client.getLock("TEST_KEY");
        System.out.println(fairLock.toString());
        fairLock.lock();
        Thread.sleep(10000);
        fairLock.unlock();
    }
}
