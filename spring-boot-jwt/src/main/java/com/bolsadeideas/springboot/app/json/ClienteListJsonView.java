package com.bolsadeideas.springboot.app.json;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Component("listar.json")
public class ClienteListJsonView extends MappingJackson2JsonView {

	@Override
	protected Object filterModel(Map<String, Object> model) {

		model.remove("titulo");
		model.remove("page");	
		Page<Cliente> clientes = (Page<Cliente>) model.get("clientes");
		model.put("clientes", clientes);
		return super.filterModel(model);
	}

}
