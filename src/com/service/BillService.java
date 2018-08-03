package com.service;

import java.util.List;

import com.entity.Bill;

public interface BillService {
	int addBill(Bill bill);
	int deleteBill(Integer id);
	int modifyBill(Bill bill);
	Bill findById(Integer id);
	Bill findByBill(Bill bill);
	List<Bill> findAll();
	List<Bill> findByProductName(Bill bill);
}
