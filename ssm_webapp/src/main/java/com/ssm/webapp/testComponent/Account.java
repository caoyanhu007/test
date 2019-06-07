package com.ssm.webapp.testComponent;

import java.util.HashMap;
import java.util.Map;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
/**
 * 缓存测试服务类组件
 * @author n006567
 *
 */
@Component
public class Account {

    /*
     * @Cacheable(value=”commonCache”)，这个注释的意思是，当调用这个方法的时候， 会从一个名叫 commonCache
     * 的缓存中查询，如果没有，则执行实际的方法（即查询数据库）， 并将执行的结果存入缓存中，否则返回缓存中的对象。 这里的缓存中的 key 就是参数
     * userName，value 就是 Account 对象。 “commonCache”缓存是在 spring*.xml 中定义的名称。
     */
    @Cacheable(value = "commonCache") // 使用了一个缓存名叫 commonCache
    public Map<String, Object> getAccountByName(String userName) {
	// 方法内部实现不考虑缓存逻辑，直接实现业务
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("abc", "111");
	map.put("def", "111");
	map.put("ghi", "111");
	System.out.println("经过getAccountByName方法体");
	return map;
    }

    /*
     * @CacheEvict  注释来标记要清空缓存的方法，当这个方法被调用后，即会清空缓存(指清空key对应的缓存)，即使方法执行有返回结果也不再存入缓存。
     * 注意@CacheEvict(value=”commonCache”, key=”#userName”)中的 Key 是用来指定缓存的 key 的，前面的 # 号代表这是一个 SpEL 表达式，
     * 此表达式可以遍历方法的参数对象（如key="#account.getName()"），具体语法可以参考 Spring 的相关文档手册。
     */
    @CacheEvict(value = "commonCache", key = "#userName") // 清空commonCache 缓存
    public void updateAccount(String userName) {
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("abc", "222");
	map.put("def", "222");
	map.put("ghi", "222");
	System.out.println("updateAccount更新方法结束");
    }
    
    /*
     * @CachePut 注释，这个注释可以确保方法被执行，同时方法的返回值也被记录到缓存中，实现缓存与数据库的同步更新。
     */
    @CachePut(value="commonCache",key="#userName")// 更新commonCache 缓存
    public Map<String, Object> updateAccountAndSave(String userName) {
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("abc", "333");
	map.put("def", "333");
	map.put("ghi", "333");
	System.out.println("updateAccountAndSave更新方法结束");
        return map;
    }

}
