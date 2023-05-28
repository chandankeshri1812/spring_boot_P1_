package com.springBoot_project_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminContoller {

	
	@RequestMapping("/dash")
	public String admin() {
		
		System.out.println("admin dashbaord");
		return "admin/adminDashboard";
	}
	
	
}
