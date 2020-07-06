package com.bolsadeideas.springboot.data.app.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.data.app.models.entity.Client;

@Service
public interface ClientServiceInterface {


	public List<Client> findAll();

	
	public void deleteById(Long id);
	

	public Optional<Client> findById(Long id);

	
	public Client save(Client client);
}
