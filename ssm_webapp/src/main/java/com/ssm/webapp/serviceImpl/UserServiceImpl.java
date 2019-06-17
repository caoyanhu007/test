package com.ssm.webapp.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.webapp.dao.UserMapper;
import com.ssm.webapp.entity.User;
import com.ssm.webapp.exception.SystemException;
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
		System.out.println("User插入前ID："+record.getId());
		int res = userMapper.insert(record);
		System.out.println("User插入后ID："+record.getId());
		try {
			userMapper.insert(record);//同一对象插入两次主键冲突、失败
		} catch (Exception e) {
			//e.printStackTrace();
			throw new SystemException("001","主键冲突异常");
		}
		System.out.println("第二次插入结束");
		return res;
	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

}
