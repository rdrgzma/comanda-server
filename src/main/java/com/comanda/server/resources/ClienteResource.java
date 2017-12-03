package com.comanda.server.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comanda.server.exception.ObjetoNaoEncontradoException;
import com.comanda.server.models.Cliente;
import com.comanda.server.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorID(@PathVariable Integer id) {
		Cliente cli = clienteService.buscarPorID(id);
		
		if(cli == null) {
			throw new ObjetoNaoEncontradoException(Cliente.class.getName()+" não encontrado Id: "
					+ id);
		}
		return ResponseEntity.ok().body(cli);	
	}
	
	@RequestMapping(value="/todos", method=RequestMethod.GET)
	public ResponseEntity<?> buscarTodos() {
		List<Cliente> cli = clienteService.buscarTodos();
		
		if(cli == null) {
			throw new ObjetoNaoEncontradoException("Estabelecimentos não encontrados");
		}
		return ResponseEntity.ok().body(cli);	
	}

}
