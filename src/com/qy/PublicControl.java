package com.qy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/public")
public class PublicControl {
	
	@RequestMapping("/password.com")
	public String password() {
		return "password";
	}
}
