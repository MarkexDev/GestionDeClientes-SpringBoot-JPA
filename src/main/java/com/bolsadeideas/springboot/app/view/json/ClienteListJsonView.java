package com.bolsadeideas.springboot.app.view.json;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.view.xlm.ClienteList;

@Component("listar.json")
public class ClienteListJsonView extends MappingJackson2JsonView{

	@Override
	protected Object filterModel(Map<String, Object> model) {
		model.remove("titulo");
		model.remove("page");
		
		//Filtro
		@SuppressWarnings("unchecked")
		List<Cliente> clientes = (List<Cliente>) model.get("clientes"); //Quitar esta linea en caso de que no funcione
		
		model.remove("clientes");
		model.put("Clientes", new ClienteList(clientes));
		
		return super.filterModel(model);
	}
	
}
