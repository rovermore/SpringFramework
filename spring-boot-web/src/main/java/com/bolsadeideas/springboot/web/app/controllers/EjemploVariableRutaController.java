package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariableRutaController {

	@GetMapping("/")
	public String pathVariables(Model model) {
		model.addAttribute("title", "Recibir parámetros del path lista URLs");
		return "variables/index";
	}
	
	@GetMapping("/string/{text}")
	public String pathVariables(@PathVariable(name="text") String textOther, Model model) {
		model.addAttribute("title", "Recibir parámetros del path");
		model.addAttribute("result", "the name of the path is: " + textOther);
		return "variables/ver";
	}
	
	@GetMapping("/string/{text}/{number}")
	public String pathVariables(@PathVariable(name="text") String textOther, @PathVariable Integer number, Model model) {
		model.addAttribute("title", "Recibir parámetros del path");
		model.addAttribute("result", "the name of the path is: " + textOther + "and the number is: " + number);
		return "variables/ver";
	}
}
