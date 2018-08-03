package com.qy;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.service.UserService;

@Controller()
@RequestMapping("/user")
public class UserControl {
	
	@Autowired
	private UserService userService;
	
	private ModelAndView mview = new ModelAndView();

	@RequestMapping(value = "/password.com", method=RequestMethod.POST)
	public void password(String oldPassword, String reNewPassword,String newPassword, 
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		User user = new User(); 
		user.setUserName(session.getAttribute("userName").toString());
		user = userService.findByUser(user);
		if(user.getUserPassword().equals(oldPassword)) {
			user.setUserPassword(reNewPassword);
			userService.modifyUser(user);
			session.invalidate();
			out.print("{\"result\":\"修改成功\"}");
		}else {
			out.print("{\"result\":\"修改失败\"}");
		}
		// TODO Auto-generated method stub
		
	}

	@RequestMapping(value = "/addUser.com", method=RequestMethod.POST)
	public void addUser(@RequestParam String userCode, @RequestParam String userName, 
			@RequestParam String userpassword, @RequestParam String gender, 
			@RequestParam String data, @RequestParam String userphone, 
			@RequestParam String userAddress, @RequestParam String userLei, 
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		User user = new User();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		user.setUserCode(userCode);
		user.setUserName(userName);
		user.setUserPassword(userpassword);
		user.setGender(Integer.valueOf(gender));
		try {
			user.setBirthday(format.parse(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setPhone(userphone);
		user.setAddress(userAddress);
		user.setUserRole(Integer.valueOf(userLei));
		user.setCreationDate(new Date());
		user.setCreatedBy(1);
		int count = userService.addUser(user);
		String result = "";
		if(count == 0) {
			result = "添加失败";
    	} else {
    		result = "添加成功";
    	}
		out.print("{\"result\":\"" + result + "\"}");
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/deleteUser.com", method=RequestMethod.POST)
	public void deleteUser(@RequestParam String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		int count = userService.deleteUser(Integer.parseInt(id));
		// TODO Auto-generated method stub
		String result = "";
		if(count == 0) {
			result = "删除失败";
    	} else {
    		result = "删除成功";
    	}
		out.print("{\"result\":\"" + result + "\"}");
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/modifyUser.com", method=RequestMethod.POST)
	public void modifyUser(@RequestParam String id, @RequestParam String userName , 
			@RequestParam String gender, @RequestParam String userphone, 
			@RequestParam String userAddress, @RequestParam String data, 
			@RequestParam String userLei, HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		User user = new User();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		user.setId(Integer.valueOf(id));
		user.setUserName(userName);
		user.setGender(Integer.parseInt(gender));
		try {
			user.setBirthday(format.parse(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setPhone(userphone);
		user.setAddress(userAddress);
		user.setUserRole(Integer.valueOf(userLei));
		user.setModifyBy(1);
		user.setModifyDate(new Date());
		int count = userService.modifyUser(user);
		String result = "";
		if(count == 0) {
			result = "修改失败";
    	} else {
    		result = "修改成功";
    	}
		out.print("{\"result\":\"" + result + "\"}");
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/selectLike.com", method=RequestMethod.POST)
	public void selectLike(@RequestParam String userName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		User user = new User();
		user.setUserName(userName);
		String html = "<tr class='firstTr'>"
        + "<th width='10%'>用户编码</th>"
        + "<th width='20%'>用户名称</th>"
        + "<th width='10%'>性别</th>"
        + "<th width='10%'>年龄</th>"
        + "<th width='10%'>电话</th>"
        + "<th width='10%'>用户类型</th>"
        + "<th width='30%'>操作</th>"
        + "</tr>";
		List<User> userList = userService.findByUserName(user);
		String gender = "";
		for (User user2 : userList) {
			if(user2.getGender() == 1) {
				gender = "男";
			}else {
				gender = "女";
			}
			html = html + "<tr><td>" + user2.getUserCode() + "</td>"
            + "<td>" + user2.getUserName() + "</td>"
            + "<td>" + gender + "</td>"
            + "<td>" + user2.getAge() + "</td>"
            + "<td>" + user2.getPhone() + "</td>"
            + "<td>" + user2.getUserRoleName() + "</td>"
            + "<td>" +
            "<a href='http://localhost:8080/smbm/SmbmServlet/user/viewJsp.com?id=" + user2.getId() + "'><img src='http://localhost:8080/smbm/img/read.png' alt='查看' title='查看'/></a>" +
            "<a href='http://localhost:8080/smbm/SmbmServlet/user/updateJsp.com?id=" + user2.getId() + "'><img src='http://localhost:8080/smbm/img/xiugai.png' alt='修改' title='修改'/></a>" +
          	"<a class='deleteUser' uid=" + user2.getId() + "><img src='http://localhost:8080/smbm/img/schu.png' alt='删除' title='删除'/></a>" 
          	+ "</td></tr>";
		}
		out.print("{\"html\":\"" + html + "\"}");
		out.flush();
		out.close();
	}
	
	@RequestMapping("/selectList.com")
	public ModelAndView selectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userList = userService.findAll();
		// TODO Auto-generated method stub
		mview.addObject("userList", userList);
		mview.setViewName("userList");
		return mview;
	}
	
	@RequestMapping("/updateJsp.com")
	public ModelAndView updateJsp(@RequestParam String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = userService.findById(Integer.parseInt(id));
		// TODO Auto-generated method stub
		mview.setViewName("userUpdate");
		mview.addObject("user", user);
		return mview;
	}
	
	@RequestMapping("/viewJsp.com")
	public ModelAndView viewJsp(@RequestParam String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = userService.findById(Integer.parseInt(id));
		// TODO Auto-generated method stub
		mview.setViewName("userView");
		mview.addObject("user", user);
		return mview;
	}
	
	@RequestMapping("/login.com")
	public ModelAndView login(@RequestParam String userName, @RequestParam String password, 
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		User newUser = new User();
		newUser.setUserName(userName);
		newUser.setUserPassword(password);
		User user = userService.findByUser(newUser);
		// TODO Auto-generated method stub
		if(user == null) {
			out.print("<script type='text/javascript'>alert('登录失败');</script>");
			mview.setViewName("login");
		}else {
			session.setAttribute("userName", userName);
			session.setMaxInactiveInterval(3000);
			out.print("<script type='text/javascript'>alert('登录成功');</script>");
			mview.setViewName("welcome");
		}
		return mview;
	}
	
	@RequestMapping("/loginOut.com")
	public ModelAndView loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		mview.setViewName("login");
		return mview;
	}
	
	@RequestMapping("/userAddJsp.com")
	public String addJsp() {
		return "userAdd";
	}
	
	@RequestMapping("/qy.com")
	public String loginJsp() {
		return "login";
	}
	
}
