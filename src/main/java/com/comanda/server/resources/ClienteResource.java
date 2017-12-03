package com.comanda.server.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comanda.server.models.Cliente;
import com.comanda.server.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cliente> buscarPorID(@PathVariable Integer id) {
		Cliente cli = clienteService.buscarPorID(id);
		return ResponseEntity.ok().body(cli);	
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> buscarTodos() {
		List<Cliente> cli = clienteService.buscarTodos();
		return ResponseEntity.ok().body(cli);	
	}

}
