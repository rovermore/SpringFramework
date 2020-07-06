package com.bolsadeideas.springboot.data.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.data.app.models.entity.Client;
import com.bolsadeideas.springboot.data.app.models.services.ClientServiceInterface;

@Controller
@SessionAttributes("client")
public class ClientController {

	@Autowired
	@Qualifier("ClientService")
	private ClientServiceInterface clientService;
	
	@GetMapping("/list")
	public String getList(Model model) {
		model.addAttribute("title", "List of clients");
		model.addAttribute("clients", clientService.findAll());
		return "list";
	}
	
	@GetMapping("/form/{id}")
	public String getClient(@PathVariable Long id, Map<String, Object> model) {
		if (id > 0 ) {
			Client client = clientService.findById(id).orElse(null);
			model.put("title", "Edit client");
			model.put("client", client);
		} else {
			return "redirect:/list";
		}
		return "form";
	}
	
	@GetMapping("/form")
	public String setUser(Map<String, Object> model) {
		Client client = new Client();
		model.put("title", "Form");
		model.put("client", client);
		return "form";
	}
	
	@PostMapping("/form")
	public String saveUser(Client client, SessionStatus status) {
		clientService.save(client);
		status.setComplete();
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteClient(@PathVariable(value="id") Long id) {
		if (id > 0) clientService.deleteById(id);
		return "redirect:/list";
	}
}
