package com.qy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

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
import com.entity.Provider;
import com.service.ProviderService;

@Controller()
@RequestMapping("/provider")
public class ProviderControl {
	
	@Autowired
	private ProviderService providerService ;
	
	private ModelAndView mview = new ModelAndView();
	
	@RequestMapping(value = "/addProvider.com", method=RequestMethod.POST)
	public void addProvider(@RequestParam String proCode, @RequestParam String proName, 
			@RequestParam String proContact, @RequestParam String proPhone, 
			@RequestParam String proAddress, @RequestParam String proFax, 
			@RequestParam String proDesc, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// TODO Auto-generated method stub
		Provider provider = new Provider();
		provider.setProCode(proCode);
		provider.setProName(proName);
		provider.setProContact(proContact);
		provider.setProPhone(proPhone);
		provider.setProAddress(proAddress);
		provider.setProFax(proFax);
		provider.setProDesc(proDesc);
		provider.setModifyBy(1);
		provider.setModifyDate(new Date());
		int count = providerService.addProvider(provider);
		if(count == 0) {
			out.print("{\"result\":\"添加失败\"}");
		}else {
			out.print("{\"result\":\"添加成功\"}");
		}
	}
	
	@RequestMapping(value = "/deleteProvider.com", method=RequestMethod.POST)
	public void deleteProvider(@RequestParam String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int count = providerService.deleteProvider(Integer.parseInt(id));
		if(count == 0) {
			out.print("{\"result\":\"删除失败\"}");
		}else {
			out.print("{\"result\":\"删除成功\"}");
		}
		// TODO Auto-generated method stub
		
	}
	
	@RequestMapping(value = "/modifyProvider.com", method=RequestMethod.POST)
	public void modifyProvider(@RequestParam String id, @RequestParam String proCode, 
			@RequestParam String proName, @RequestParam String proContact, 
			@RequestParam String proPhone, @RequestParam String proAddress, 
			@RequestParam String proFax, @RequestParam String proDesc, 
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Provider provider = new Provider();
		provider.setId(Integer.parseInt(id));
		provider.setProCode(proCode);
		provider.setProName(proName);
		provider.setProContact(proContact);
		provider.setProPhone(proPhone);
		provider.setProAddress(proAddress);
		provider.setProFax(proFax);
		provider.setProDesc(proDesc);
		provider.setCreatedBy(1);
		provider.setCreationDate(new Date());
		int count = providerService.modifyProvider(provider);
		if(count == 0) {
			out.print("{\"result\":\"修改失败\"}");
		}else {
			out.print("{\"result\":\"修改成功\"}");
		}
		// TODO Auto-generated method stub
		
	}
	
	@RequestMapping(value = "/selectLike.com", method=RequestMethod.POST)
	public void selectLike(@RequestParam String proName, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Provider provider = new Provider();
		provider.setProName(proName);
		List<Provider> providerList = providerService.findByProName(provider);
		String jsonProvider = JSON.toJSONString(providerList);
		// TODO Auto-generated method stub
		out.print(jsonProvider);
	}
	
	@RequestMapping("/selectList.com")
	public ModelAndView selectList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Provider> providerList = providerService.findAll();
		mview.addObject("providerList", providerList);
		mview.setViewName("providerList");
		// TODO Auto-generated method stub
		return mview;
	}
	
	@RequestMapping("/updateJsp.com")
	public ModelAndView updateJsp(@RequestParam String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Provider provider = providerService.findById(Integer.parseInt(id));
		mview.addObject("provider", provider);
		mview.setViewName("providerUpdate");
		// TODO Auto-generated method stub
		return mview;
	}
	
	@RequestMapping("/viewJsp.com")
	public ModelAndView viewJsp(@RequestParam String id , HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Provider provider = providerService.findById(Integer.parseInt(id));
		mview.addObject("provider", provider);
		mview.setViewName("providerView");
		// TODO Auto-generated method stub
		return mview;
		
	}
	
	@RequestMapping("/providerAddJsp.com")
	public String addJsp() {
		return "providerAdd";
	}

}
