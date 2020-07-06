package com.bolsadeideas.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.form.app.services.CountryService;

@Component
public class CountryPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private CountryService countryService;
	
	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		Integer idInteger = Integer.parseInt(id);
		this.setValue(countryService.getCountryById(idInteger));
	}

	
}
