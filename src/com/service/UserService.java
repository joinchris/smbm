package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	int addUser(User user);
	int deleteUser(Integer id);
	int modifyUser(User user);
	User findById(Integer id);
	User findByUser(User user);
	List<User> findAll();
	List<User> findByUserName(User user);
}
