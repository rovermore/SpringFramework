package com.bolsadeideas.springboot.schedule.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping({"/","/index"})
	public String index(Model model) {
		model.addAttribute("welcome", "Welcome to open schedule");
		return "index";
	}

	@GetMapping("/closed")
	public String closed(Model model) {
		
		return "closed";
	}
}
