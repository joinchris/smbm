package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.RoleMapper;
import com.entity.Role;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	
	@Override
	public List<Role> findAll() {
		List<Role> list = roleMapper.findRoleAll();
		// TODO Auto-generated method stub
		return list;
	}
}
