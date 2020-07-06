package com.bolsadeideas.springboot.error.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bolsadeideas.springboot.error.app.errors.UserNotFoundException;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(ArithmeticException.class)
	public String aritmethicError(Exception e, Model model) {
		model.addAttribute("error","Aritmethic error");
		model.addAttribute("message",e.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());

		return "error/aritmethic";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatError(Exception e, Model model) {
		model.addAttribute("error","Number format error");
		model.addAttribute("message",e.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());

		return "error/numberformat";
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public String userNotFoundError(UserNotFoundException e, Model model) {
		model.addAttribute("error","User not found in the list");
		model.addAttribute("message",e.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());

		return "error/user-not-found";
	}
}
