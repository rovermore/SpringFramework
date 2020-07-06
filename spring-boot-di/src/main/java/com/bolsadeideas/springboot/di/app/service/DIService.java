package com.bolsadeideas.springboot.di.app.service;

import org.springframework.stereotype.Service;

@Service("DIService")
public class DIService implements ServiceInterface {

	@Override
	public String operation() {
		return "operación muy importatnte";
	}

	
}
