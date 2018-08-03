package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ProviderMapper;
import com.entity.Provider;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
	
	@Autowired
	private ProviderMapper providerMapper;	
	
	@Override
	public int addProvider(Provider provider) {
		int result = providerMapper.addProvider(provider);
		// TODO Auto-generated method stub
		return result;
	}
	@Override
	public int deleteProvider(Integer id) {
		int result = providerMapper.deleteProvider(id);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int modifyProvider(Provider provider) {
		int result = providerMapper.modifyProvider(provider);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public Provider findById(Integer id) {
		Provider provider = providerMapper.findByProviderId(id);
		// TODO Auto-generated method stub
		return provider;
	}

	@Override
	public Provider findByUser(Provider provider) {
		List<Provider> list = providerMapper.findByProName(provider);
		// TODO Auto-generated method stub
		return list.get(0);
	}

	@Override
	public List<Provider> findAll() {
		List<Provider> list = providerMapper.findProviderAll();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Provider> findByProName(Provider provider) {
		List<Provider> list = providerMapper.findByProName(provider);
		// TODO Auto-generated method stub
		return list;
	}
}
