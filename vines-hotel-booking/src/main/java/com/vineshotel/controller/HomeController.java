package com.vineshotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	 @GetMapping("/")
	    public String rootHome() {
	        return "home";
	    }
	 
    @GetMapping("/home")
    public String homePage() {
        return "home";   // home.html
    }
}
