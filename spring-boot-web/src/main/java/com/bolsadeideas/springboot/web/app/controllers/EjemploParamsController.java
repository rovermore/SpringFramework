package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/string")
	public String params(
			@RequestParam(name = "param", required = false, defaultValue = "some value") String text,
			Model model) {
		model.addAttribute("result", "el resultado es: ".concat(text));
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String params(@RequestParam String text, @RequestParam Integer number, Model model) {
		model.addAttribute("result", "el resultado es: " + text + " y el número es " + number);
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String params(HttpServletRequest request, Model model) {
		String text = request.getParameter("text");;
		Integer number = null;
		try {
		number = Integer.parseInt(request.getParameter("number"));
		} catch (NumberFormatException e) {
		}
		model.addAttribute("result", "el resultado es: " + text + " y el número es: " + number);
		return "params/ver";
	}
}
