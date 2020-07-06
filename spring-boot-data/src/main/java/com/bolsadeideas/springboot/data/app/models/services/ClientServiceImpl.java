package com.bolsadeideas.springboot.data.app.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.data.app.models.dao.ClientDaoInterface;
import com.bolsadeideas.springboot.data.app.models.entity.Client;

@Service("ClientService")
public class ClientServiceImpl implements ClientServiceInterface {

	@Autowired
	private ClientDaoInterface clientDao;
	
	
	@Transactional(readOnly=true)
	@Override
	public List<Client> findAll() {
		return (List<Client>) clientDao.findAll();
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		clientDao.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Optional<Client> findById(Long id) {
		return clientDao.findById(id);
	}

	@Transactional
	@Override
	public Client save(Client client) {
		return clientDao.save(client);
	}
	
}
