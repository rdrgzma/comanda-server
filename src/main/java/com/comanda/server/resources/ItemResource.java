package com.comanda.server.resources;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.comanda.server.models.Item;
import com.comanda.server.models.Pedido;
import com.comanda.server.services.ItemService;
import com.comanda.server.services.PedidoService;

@RestController
@RequestMapping(value="/Itens")
public class ItemResource {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Item> buscarPorID(@PathVariable Integer id) {
		Item it = itemService.buscarPorID(id);
		return ResponseEntity.ok().body(it);	
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> buscarTodos() {
		List<Item> itens = itemService.buscarTodos();
		return ResponseEntity.ok().body(itens);	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Item item, @RequestBody Integer idPedido) {
		Pedido pedido = pedidoService.buscarPorId(idPedido);
		pedido.getItens().addAll(Arrays.asList(item));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
