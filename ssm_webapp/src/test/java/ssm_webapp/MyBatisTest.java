package ssm_webapp;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import com.ssm.webapp.entity.User;
import com.ssm.webapp.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-application.xml" })
public class MyBatisTest {

	@Resource
	private IUserService userService;

	@Test
	public void test() {
		User user = userService.getUserById(1);
		System.out.println("==>" + JSON.toJSONString(user));
	}

}
