package com.ssm.webapp.service;

import com.ssm.webapp.entity.User;

public interface IUserService {
	
	public User getUserById(Integer id );
	
	public int insertUser(User record);
	
	public int insertSelective(User record);
	
}
