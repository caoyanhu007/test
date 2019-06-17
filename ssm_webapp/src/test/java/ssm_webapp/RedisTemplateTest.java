package ssm_webapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-application.xml" })
public class RedisTemplateTest {

    @Autowired
    public RedisTemplate<String, String> redisTemplate;

    @Test
    public void RedisClusterTemplateTest() {
	ListOperations<String, String> listOperations = redisTemplate.opsForList();
	for (int i = 0; i < 10; i++) {
	    listOperations.leftPush("kkk", "val"+i);
	}

	ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
	valueOperations.set("uuu", "111");

    }

}
