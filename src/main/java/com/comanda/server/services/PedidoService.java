package com.comanda.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.models.Pedido;
import com.comanda.server.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	public Pedido buscarPorId(Integer id) {
		return pedidoRepository.findOne(id);
		
	}
	
	public List<Pedido> buscarTodos(){
		return pedidoRepository.findAll();
	}

}
