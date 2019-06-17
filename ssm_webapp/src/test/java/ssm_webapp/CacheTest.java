package ssm_webapp;

import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.webapp.testComponent.Account;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-application.xml" })
public class CacheTest {

    @Autowired
    public Account account;

    @Test
    public void RedisCacheTest() {
	
	String par ="RedisCacheTest_Cacheable";
	System.out.println("\n\n @Cacheable测试开始,第一次调用getAccountByName方法");
	Map<String, Object> map1 = account.getAccountByName(par);
	System.out.println("第一次调用getAccountByName方法结果"+map1.toString());
	System.out.println("第二次调用getAccountByName方法");
	Map<String, Object> map2 = account.getAccountByName(par);
	System.out.println("第二次调用getAccountByName方法结果"+map2.toString()+"\n\n");
	
	
	String par1 ="RedisCacheTest_CacheEvict";
	System.out.println("@CacheEvict测试开始,调用updateAccountNoSave方法");
	Map<String, Object> map3 = account.updateAccountNoSave(par1);
	System.out.println("调用updateAccountNoSave方法结果"+map3.toString());
	System.out.println("调用getAccountByName方法");
	Map<String, Object> map4 = account.getAccountByName(par1);
	System.out.println("调用getAccountByName方法结果"+map4.toString()+"\n\n");
	
	
	String par2 ="RedisCacheTest_CachePut";
	System.out.println("@CachePut测试开始,调用updateAccountAndSave方法");
	Map<String, Object> map5 = account.updateAccountAndSave(par2);
	System.out.println("调用updateAccountAndSave方法结果"+map5.toString());
	System.out.println("调用getAccountByName方法");
	Map<String, Object> map6 = account.getAccountByName(par2);
	System.out.println("调用getAccountByName方法结果"+map6.toString()+"\n\n");
	
    }
    

}
