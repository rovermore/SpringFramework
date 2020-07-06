package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${text.indexcontroler.index.title}")
	private String indexTitle;
	
	@Value("${text.indexcontroler.profile.title}")
	private String profileTitle;
	
	@Value("${text.indexcontroler.list.title}")
	private String listTitle;

	@GetMapping({"/index", "/", "", "/home"})
	public String index(Map<String, Object> map) {
		map.put("title", indexTitle);
		return "index";
	}
	
	@RequestMapping("/profile")
	public String profile(Model model) {
		User user = new User();
		user.setName("Roberto");
		user.setSurname("Moreno");
		model.addAttribute("user", user);
		model.addAttribute("title", profileTitle.concat(user.getName()));
		return "profile";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("title", listTitle);
		return "list";
	}
	
	@ModelAttribute("users")
	public List<User> populateUsers(){
		List<User> users = new ArrayList<>();
		users.add(new User("Noel","Gallagher","noel@gmail.com"));
		users.add(new User("Alex","Turner","alex@gmail.com"));
		users.add(new User("Sergio","Pizzorno","noel@gmail.com"));
		return users;
	}
}
