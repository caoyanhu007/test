package ssm_webapp;

import java.util.Iterator;
import java.util.Set;
import redis.clients.jedis.Jedis;

public class JedisTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("47.95.112.188", 10000);
		jedis.auth("caoyanhu007");
		System.out.println("连接成功");
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
		jedis.close();
	}

}
