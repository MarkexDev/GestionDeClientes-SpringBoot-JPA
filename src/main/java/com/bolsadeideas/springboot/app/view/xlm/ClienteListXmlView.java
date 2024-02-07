package com.bolsadeideas.springboot.app.view.xlm;

import java.util.List;
import java.util.Map;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("listar.xml")
public class ClienteListXmlView extends MarshallingView{
	
	
	public ClienteListXmlView(Jaxb2Marshaller marshaller) {
		super(marshaller);
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//model.remove()...Elimina los elementos para no renderizarlos. No los borra de la BD
		model.remove("titulo");
		model.remove("page");
		
		@SuppressWarnings("unchecked")
		List<Cliente> clientes = (List<Cliente>) model.get("clientes");
		model.remove("clientes");
		
		model.put("clienteList", new ClienteList(clientes));
		
		super.renderMergedOutputModel(model, request, response);
	}
	
}
