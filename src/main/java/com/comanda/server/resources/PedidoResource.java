package com.comanda.server.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comanda.server.dto.PedidoDTO;
import com.comanda.server.models.Pedido;
import com.comanda.server.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PedidoDTO> buscarPorID(@PathVariable Integer id) {
		Pedido ped = pedidoService.buscarPorId(id);
		PedidoDTO pedDTO = new PedidoDTO(ped);
		return ResponseEntity.ok().body(pedDTO);	
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PedidoDTO>> buscarTodos() {
		List<Pedido> list = pedidoService.buscarTodos();
		List<PedidoDTO> listDTO = list.stream().map(ped -> new PedidoDTO(ped)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	}

}
