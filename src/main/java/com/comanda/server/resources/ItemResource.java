package com.comanda.server.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comanda.server.exception.ObjetoNaoEncontradoException;
import com.comanda.server.models.Item;
import com.comanda.server.models.Pedido;
import com.comanda.server.services.ItemService;

@RestController
@RequestMapping(value="/Itens")
public class ItemResource {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorID(@PathVariable Integer id) {
		Item it = itemService.buscarPorID(id);
		
		if(it == null) {
			throw new ObjetoNaoEncontradoException(Pedido.class.getName()+" não encontrado Id: "
					+ id);
		}
		return ResponseEntity.ok().body(it);	
	}
	
	@RequestMapping(value="/todos", method=RequestMethod.GET)
	public ResponseEntity<?> buscarTodos() {
		List<Item> ped = itemService.buscarTodos();
		
		if(ped == null) {
			throw new ObjetoNaoEncontradoException("Itens não encontrados");
		}
		return ResponseEntity.ok().body(ped);	
	}

}
