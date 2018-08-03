package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.UserMapper;
import com.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int addUser(User user) {
		int result = userMapper.addUser(user);
		// TODO Auto-generated method stub
		return result;
	}
	
	
	@Override
	public int deleteUser(Integer id) {
		int result = userMapper.deleteUser(id);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int modifyUser(User user) {
		int result = userMapper.modifyUser(user);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public User findByUser(User user) {
		List<User> userList = userMapper.findByUserName(user);
		// TODO Auto-generated method stub
		return userList.get(0);
	}
	
	@Override
	public List<User> findAll() {
		List<User> list = userMapper.findUserAll();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<User> findByUserName(User user) {
		List<User> list = userMapper.findByUserName(user);
		// TODO Auto-generated method stub
		return list;
	}
	
	@Override
	public User findById(Integer id) {
		User user = userMapper.findByUserId(id);
		// TODO Auto-generated method stub
		return user;
	}

	


}
