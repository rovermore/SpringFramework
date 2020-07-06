package com.bolsadeideas.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsadeideas.springboot.error.app.errors.UserNotFoundException;
import com.bolsadeideas.springboot.error.app.models.domain.User;
import com.bolsadeideas.springboot.error.app.services.UserService;

@Controller
public class AppController {
	
	@Autowired
	private UserService userService;

	@SuppressWarnings("unused")
	@GetMapping({"/", "/index"})
	public String index() {
		//Integer number = 100/0;
		Integer number = Integer.parseInt("10x");
		return "index";
	}
	
	@GetMapping("user/{id}")
	public String getUser(@PathVariable(name = "id") Integer id, Model model) {
		User user = userService.optGetUserById(id).orElseThrow(() -> new UserNotFoundException(id.toString()));
		/*
		 * if (user == null) { throw new UserNotFoundException(id.toString()); }
		 */
		model.addAttribute("user", user);
		return "user";
	}
}
