package ssm_webapp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ssm.webapp.redis.JedisClientCluster;
import com.ssm.webapp.redis.JedisClusterTemplate;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-application.xml" })
public class JedisClusterTest {

    @Autowired
    public JedisClientCluster jedisClientCluster;

    @Autowired
    public JedisClusterTemplate jedisClusterTemplate;

    @Test
    public void JedisClientClusterTest() {
	for (int i = 0; i < 10; i++) {
	    jedisClientCluster.hset("key", "field" + i, "value" + i);
	}
	List<String> list = jedisClientCluster.hvals("key");
	System.out.println("=========" + list.toString());
    }

    @Test
    public void RedisClusterTemplateTest() {
	Boolean boo = jedisClusterTemplate.exists("aaa");
	System.out.println("boo=========" + boo);
	Long lon = jedisClusterTemplate.hset("ooo", "aaa", "bbb");
	System.out.println("lon=========" + lon);
    }

}
