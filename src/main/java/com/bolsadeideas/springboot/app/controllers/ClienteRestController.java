package com.bolsadeideas.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.app.models.services.IClienteService;
import com.bolsadeideas.springboot.app.view.xlm.ClienteList;

@RestController //Inyecta la implementacion necesaria para REST
@RequestMapping("/api/clientes")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping(value = "/listar")
	public ClienteList listar() {
		
		return new ClienteList(clienteService.findAll());		
	}
	
}
