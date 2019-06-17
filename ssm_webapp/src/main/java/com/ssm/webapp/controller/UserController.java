package com.ssm.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.webapp.entity.User;
import com.ssm.webapp.exception.SystemException;
import com.ssm.webapp.service.IUserService;
/**
 * 
 * @author Administrator
 *  测试
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	

	
	@RequestMapping("/user/showUser")
	public String showUser(HttpServletRequest request,Model model){
		String id =request.getParameter("id");
		if (!StringUtils.isEmpty(id)) {
			int userId = Integer.parseInt(id);
			User user = this.userService.getUserById(userId);
			model.addAttribute("user", user);
		}
		return "showUser";
	}
	
	/**
	 * 测试事务
	 */
	@RequestMapping("/user/testTransaction")
	public String testTransaction(HttpServletRequest request,Model model){
		User user1 = new User();
		user1.setUsername("user1");
		user1.setPassword("123456");
		user1.setAge(28);
		userService.insertUser(user1);
		//return "redirect:/index.jsp";
		return "test";
	}
	
	/**
	 * 异常测试
	 * @throws Exception 
	 */
	@RequestMapping("/user/testException")
	public String testException(HttpServletRequest request,Model model)  {
		try {
			System.out.println(10/0);
		} catch (Exception e) {
			throw new SystemException("001","这是一个测试异常");
		}
		System.out.println("没有异常");
		return "test";
	}
	
	
}
