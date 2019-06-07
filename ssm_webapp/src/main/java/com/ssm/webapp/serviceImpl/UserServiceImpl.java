package com.ssm.webapp.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.webapp.dao.UserMapper;
import com.ssm.webapp.entity.User;
import com.ssm.webapp.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int insertUser(User record) {
		int id1 = userMapper.insert(record);
		System.out.println("第一次插入返回："+id1);
		System.out.println(10/0);
		int id2 = userMapper.insert(record);
		System.out.println("第二次插入返回："+id2);
		return id1+id2;
	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

}
