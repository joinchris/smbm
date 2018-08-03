package com.dao;

import java.util.List;

import com.entity.Bill;

public interface BillMapper {
	int addBill(Bill bill);
	int deleteBill(Integer id);
	int modifyBill(Bill bill);
	Bill findByBillId(Integer id);
	List<Bill> findByBillName(Bill bill);
	List<Bill> findBillAll();
}
