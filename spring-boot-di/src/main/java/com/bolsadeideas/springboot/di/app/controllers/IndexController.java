package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.service.ServiceInterface;

@Controller
public class IndexController {
	
	@Autowired
	@Qualifier("DIService")
	private ServiceInterface service;
	
	@GetMapping({"/","","/index"})
	public String index(Model model) {
		model.addAttribute("object", service.operation());
		return "index";
	}
}
