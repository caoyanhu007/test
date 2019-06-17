package ssm_webapp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Set;
import redis.clients.jedis.Jedis;

public class JedisTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.1.8", 8001);
		jedis.auth("caoyanhu007");
		System.out.println("连接成功");
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			byte[] bytes = jedis.get(key.getBytes());
			Object obj =toObject(bytes);
			System.out.println(key+":"+obj);
		}
		jedis.close();
	}
	
	public static Object toObject(byte[] bytes) {
		Object obj = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bis);
			obj = ois.readObject();
			ois.close();
			bis.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return obj;
	}

}
