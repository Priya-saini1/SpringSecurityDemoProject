package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class adminController {
	
	@GetMapping("/admin")
	@ResponseBody
	public String showAdminPage() {
		return "Hey Admin!! This is the Admin Page ";
	}


}
