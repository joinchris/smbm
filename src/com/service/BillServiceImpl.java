package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BillMapper;
import com.entity.Bill;

@Service("billService")
public class BillServiceImpl implements BillService{
	
	@Resource
	private BillMapper billMapper;
	
	@Override
	public int addBill(Bill bill) {
		int result = billMapper.addBill(bill);
		// TODO Auto-generated method stub
		return result;
	}
	@Override
	public int deleteBill(Integer id) {
		int result = billMapper.deleteBill(id);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int modifyBill(Bill bill) {
		int result = billMapper.modifyBill(bill);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public Bill findById(Integer id) {
		Bill bill = billMapper.findByBillId(id);
		// TODO Auto-generated method stub
		return bill;
	}

	@Override
	public Bill findByBill(Bill bill) {
		List<Bill> list = billMapper.findByBillName(bill);
		// TODO Auto-generated method stub
		return list.get(0);
	}

	@Override
	public List<Bill> findAll() {
		List<Bill> list = billMapper.findBillAll();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Bill> findByProductName(Bill bill) {
		List<Bill> list = billMapper.findByBillName(bill);
		// TODO Auto-generated method stub
		return list;
	}

}
