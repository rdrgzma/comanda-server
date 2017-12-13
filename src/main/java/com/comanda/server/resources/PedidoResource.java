package com.comanda.server.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.comanda.server.dto.PedidoDTO;
import com.comanda.server.models.Pedido;
import com.comanda.server.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PedidoDTO> buscarPorID(@PathVariable Integer id) {
		Pedido ped = pedidoService.buscarPorId(id);
		PedidoDTO pedDTO = new PedidoDTO(ped);
		return ResponseEntity.ok().body(pedDTO);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDTO>> buscarTodos() {
		List<Pedido> list = pedidoService.buscarTodos();
		List<PedidoDTO> listDTO = list.stream().map(ped -> new PedidoDTO(ped)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Pedido pedido) {
		pedido = pedidoService.salvar(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}/cancelar", method = RequestMethod.GET)
	public ResponseEntity<?> cancelar(@PathVariable Integer id) {
		Pedido ped = pedidoService.buscarPorId(id);
			if(pedidoService.CancelarPedido(ped)) {
				PedidoDTO pedDTO = new PedidoDTO(ped);
				return ResponseEntity.ok().body(pedDTO);
			}
		
		return ResponseEntity.unprocessableEntity().build();

	}
	
	@RequestMapping(value="{id}/atualizar",method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@PathVariable Integer id,@RequestBody Pedido pedido) {
		pedido = pedidoService.atualizar(id, pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
