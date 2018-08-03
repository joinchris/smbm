package com.dao;

import java.util.List;

import com.entity.Provider;

public interface ProviderMapper {
	int addProvider(Provider provider);
	int deleteProvider(Integer id);
	int modifyProvider(Provider provider);
	Provider findByProviderId(Integer id);
	List<Provider> findByProName(Provider provider);
	List<Provider> findProviderAll();
}
