package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository("userMapper")
public interface UserMapper {
	int addUser(User user);
	int deleteUser(Integer id);
	int modifyUser(User user);
	User findByUserId(Integer id);
	List<User> findByUserName(User user);
	List<User> findUserAll();
}
