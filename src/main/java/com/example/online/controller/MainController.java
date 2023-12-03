package com.example.online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
	@GetMapping("/onlineSurveyPage")
	public String homePageMethod() {
		return "onlineSurveyFirstPage";
	}
   
	@GetMapping("/Signin")
	public String signInCaller()
	{
		return "Signin";
	}
	
	@GetMapping("/access-denied")
	public String acessDeniedPage()
	{
		return "aceess_deniedPage";
	}  
	
}
