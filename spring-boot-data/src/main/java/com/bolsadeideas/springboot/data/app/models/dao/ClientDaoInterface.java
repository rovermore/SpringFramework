package com.bolsadeideas.springboot.data.app.models.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.data.app.models.entity.Client;

@Repository("ClientDaoInterface")
public interface ClientDaoInterface extends CrudRepository<Client, Long> {
	


}
