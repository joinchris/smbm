package com.service;

import java.util.List;

import com.entity.Provider;

public interface ProviderService {
	int addProvider(Provider provider);
	int deleteProvider(Integer id);
	int modifyProvider(Provider provider);
	Provider findById(Integer id);
	Provider findByUser(Provider provider);
	List<Provider> findAll();
	List<Provider> findByProName(Provider provider);
}
