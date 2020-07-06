package com.bolsadeideas.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.editors.CountryPropertyEditor;
import com.bolsadeideas.springboot.form.app.editors.RoleEditor;
import com.bolsadeideas.springboot.form.app.editors.UpperCaseEditor;
import com.bolsadeideas.springboot.form.app.models.domain.Country;
import com.bolsadeideas.springboot.form.app.models.domain.Role;
import com.bolsadeideas.springboot.form.app.models.domain.User;
import com.bolsadeideas.springboot.form.app.services.CountryService;
import com.bolsadeideas.springboot.form.app.services.RoleService;
import com.bolsadeideas.springboot.form.app.validators.UserValidator;

@Controller
@SessionAttributes("user")
public class FormController {
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private CountryPropertyEditor countryPropertyEditor;
	
	@Autowired
	private RoleEditor roleEditor;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private RoleService roleService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(userValidator);
		dataBinder.registerCustomEditor(String.class, new UpperCaseEditor());
		dataBinder.registerCustomEditor(Country.class,"country", countryPropertyEditor);
		dataBinder.registerCustomEditor(Role.class,"roles", roleEditor);

	}

	@GetMapping("/form")
	public String getForm(Model model) {
		User user = new User();
		user.setId("29-4B5-45");
		model.addAttribute("user", user);
		return "form";
	}
	
	@PostMapping("/form")
	public String postForm(@Valid User user, BindingResult result,  Model model) {
		//userValidator.validate(user, result);
		
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "form";
		}
		
		return "redirect:/result";
	}
	
	@GetMapping("/result")
	public String getResult(@SessionAttribute(name = "user", required = false)User user,  Model model, SessionStatus status) {
		
		if(user== null)return "redirect:/form";
		
		model.addAttribute("user", user);
		status.setComplete();
		return "result";
	}
	
	  @ModelAttribute("countries") 
	  public List<Country> getCountries(){
	  return countryService.getCountryList(); }
	 
	  @ModelAttribute("roleList") 
	  public List<Role> getRoleList(){ 
		  return roleService.getRoleList();
	  }
	 
}
