package com.comanda.server.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.exception.ObjetoNaoEncontradoException;
import com.comanda.server.models.Item;
import com.comanda.server.models.Pedido;
import com.comanda.server.repositories.ItemRepository;
import com.comanda.server.repositories.PedidoRepository;
import com.comanda.server.repositories.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ItemRepository itemRepository;

	public Pedido buscarPorId(Integer id) {
		Pedido ped = pedidoRepository.findOne(id);
		if (ped == null) {
			throw new ObjetoNaoEncontradoException(Pedido.class.getName() + " não encontrado Id: " + id);
		}
		return ped;
	}

	public List<Pedido> buscarTodos() {
		List<Pedido> peds = pedidoRepository.findAll();
		if (peds == null) {
			throw new ObjetoNaoEncontradoException("Pedidos não encontrados");
		}
		return peds;
	}

	public Pedido salvar(Pedido pedido) {
		//pedido.setId(null);
		pedido.setData(new Date());
		pedidoRepository.save(pedido);
		for (Item it : pedido.getItens() ) {
			it.setPrecoProduto(produtoRepository.findOne(it.getProduto().getId()).getPreco());
			it.setPedido(pedido);
		}
		
		itemRepository.save(pedido.getItens());
		return pedido;
	}



}
