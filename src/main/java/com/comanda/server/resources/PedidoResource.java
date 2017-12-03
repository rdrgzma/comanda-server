package com.comanda.server.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comanda.server.exception.ObjetoNaoEncontradoException;
import com.comanda.server.models.Pedido;
import com.comanda.server.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorID(@PathVariable Integer id) {
		Pedido ped = pedidoService.buscarPorId(id);
		
		if(ped == null) {
			throw new ObjetoNaoEncontradoException(Pedido.class.getName()+" não encontrado Id: "
					+ id);
		}
		return ResponseEntity.ok().body(ped);	
	}
	
	@RequestMapping(value="/todos", method=RequestMethod.GET)
	public ResponseEntity<?> buscarTodos() {
		List<Pedido> ped = pedidoService.buscarTodos();
		
		if(ped == null) {
			throw new ObjetoNaoEncontradoException("Pedidos não encontrados");
		}
		return ResponseEntity.ok().body(ped);	
	}

}
