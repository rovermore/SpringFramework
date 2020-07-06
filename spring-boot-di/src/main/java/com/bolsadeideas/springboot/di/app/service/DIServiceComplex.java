package com.bolsadeideas.springboot.di.app.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("DIServiceComplex")
@Primary
public class DIServiceComplex implements ServiceInterface {

	@Override
	public String operation() {
		return "operación muy importante y compleja";
	}

	
}
