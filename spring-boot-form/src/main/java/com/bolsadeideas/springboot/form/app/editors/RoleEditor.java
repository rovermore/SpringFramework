package com.bolsadeideas.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.form.app.services.RoleService;

@Component
public class RoleEditor extends PropertyEditorSupport {

	@Autowired
	private RoleService roleService;
	
	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		try {
		Integer id = Integer.parseInt(idString);
		setValue(roleService.getRoleById(id));
		} catch (NumberFormatException e) {
			setValue(null);
		}
	}

	
}
