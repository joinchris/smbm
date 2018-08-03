package com.qy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.entity.Bill;
import com.entity.Provider;
import com.service.BillService;
import com.service.ProviderService;

@Controller()
@RequestMapping("/bill")
public class BillControl {
	
	@Resource
	private ProviderService providerService ;
	
	@Resource
	private BillService billService ;
	
	private ModelAndView mview = new ModelAndView();
	
	@RequestMapping("/addJsp.com")
	public ModelAndView addJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Provider> providerList = providerService.findAll();
		mview.addObject("providerList", providerList);
		mview.setViewName("billAdd");
		// TODO Auto-generated method stub
		return mview;
	}

	@RequestMapping("/viewJsp.com")
	public ModelAndView viewJsp(@RequestParam String id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Bill bill = billService.findById(Integer.parseInt(id));
		List<Provider> providerList = providerService.findAll();
		mview.addObject("providerList", providerList);
		mview.addObject("bill", bill);
		mview.setViewName("billView");
		// TODO Auto-generated method stub
		return mview;
	}

	@RequestMapping("/updateJsp.com")
	public ModelAndView updateJsp(@RequestParam String id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Bill bill = billService.findById(Integer.parseInt(id));
		List<Provider> providerList = providerService.findAll();
		mview.addObject("providerList", providerList);
		mview.addObject("bill", bill);
		mview.setViewName("billUpdate");
		// TODO Auto-generated method stub
		return mview;
	}

	@RequestMapping(value = "/selectLike.com", method=RequestMethod.POST)
	public void selectLike(@RequestParam String productName, @RequestParam String providerId, 
			@RequestParam String isPayment, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		Bill bill = new Bill();
		if(!productName.equals("") && productName != null && !productName.equals("--请选择--")) {
			bill.setProductName(productName);
		}
		if(!providerId.equals("") && providerId != null && !providerId.equals("--请选择--")) {
			bill.setProviderId(Integer.parseInt(providerId));
		}
		if(!isPayment.equals("") && isPayment != null && !isPayment.equals("--请选择--")) {
			bill.setIsPayment(Integer.parseInt(isPayment));
		}
		// TODO Auto-generated method stub
		List<Bill> billList = billService.findByProductName(bill);
		String JsonBill = JSON.toJSONString(billList);
		out.print(JsonBill);
	}

	@RequestMapping("/selectList.com")
	public ModelAndView selectList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Bill> billList = billService.findAll();
		request.setAttribute("billList", billList);
		List<Provider> providerList = providerService.findAll();
		mview.addObject("providerList", providerList);
		mview.setViewName("billList");
		// TODO Auto-generated method stub
		return mview;
	}
	
	@RequestMapping(value = "/modifyBill.com", method=RequestMethod.POST)
	public void modifyBill(@RequestParam String id, @RequestParam String billCode, @RequestParam String productName, 
			@RequestParam String productUnit, @RequestParam String productCount, @RequestParam String totalPrice,
			@RequestParam String isPayment,@RequestParam String providerId,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		Bill bill = new Bill();
		bill.setId(Integer.parseInt(id));
		bill.setBillCode(billCode);
		bill.setProductName(productName);
		bill.setProductUnit(productUnit);
		bill.setProductCount(Integer.parseInt(productCount));
		bill.setTotalPrice(Float.parseFloat(totalPrice));
		bill.setProductName(productName);
		bill.setIsPayment(Integer.parseInt(isPayment));
		bill.setProviderId(Integer.parseInt(providerId));
		bill.setModifyBy(1);
		bill.setModifyDate(new Date());
		int count = billService.modifyBill(bill);
		if(count == 0) {
			out.print("{\"result\":\"修改失败\"}");
		}else {
			out.print("{\"result\":\"修改成功\"}");
		}
	}

	@RequestMapping(value = "/deleteBill.com", method=RequestMethod.POST)
	public void deleteBill(@RequestParam String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int count = billService.deleteBill(Integer.parseInt(id));
		if(count == 0) {
			out.print("{\"result\":\"删除失败\"}");
		}else {
			out.print("{\"result\":\"删除成功\"}");
		}
	}

	@RequestMapping(value = "/addBill.com", method=RequestMethod.POST)
	public void addBill(@RequestParam String billCode, @RequestParam String productName, 
			@RequestParam String productUnit, @RequestParam String productCount, @RequestParam String totalPrice, 
			@RequestParam String providerId, @RequestParam String isPayment,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		Bill bill = new Bill();
		bill.setBillCode(billCode);
		bill.setProductName(productName);
		bill.setProductUnit(productUnit);
		bill.setProductCount(Integer.parseInt(productCount));
		bill.setTotalPrice(Float.parseFloat(totalPrice));
		bill.setIsPayment(Integer.parseInt(isPayment));
		bill.setProviderId(Integer.parseInt(providerId));
		bill.setCreatedBy(1);
		bill.setCreationDate(new Date());
		int count = billService.addBill(bill);
		if(count == 0) {
			out.print("{\"result\":\"添加失败\"}");
		}else {
			out.print("{\"result\":\"添加成功\"}");
		}
		// TODO Auto-generated method stub
		
	}
	
	@RequestMapping("/billAddJsp.com")
	public String addJsp() {
		return "billAdd";
	}

}
