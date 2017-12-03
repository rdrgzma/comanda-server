package com.comanda.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.exception.ObjetoNaoEncontradoException;
import com.comanda.server.models.Pedido;
import com.comanda.server.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	public Pedido buscarPorId(Integer id) {
		Pedido ped = pedidoRepository.findOne(id);	
		if(ped == null) {
			throw new ObjetoNaoEncontradoException(Pedido.class.getName()+" não encontrado Id: "
					+ id);
		}
		return ped;	
	}
	
	public List<Pedido> buscarTodos(){
		List<Pedido> peds = pedidoRepository.findAll();	
		if(peds == null) {
			throw new ObjetoNaoEncontradoException("Pedidos não encontrados");
		}
		return peds;
	}

}
