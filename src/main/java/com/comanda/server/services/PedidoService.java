package com.comanda.server.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.enums.StatusItem;
import com.comanda.server.enums.StatusPedido;
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
		if(pedido.getId()==null) {
			pedido.setData(new Date());
			pedidoRepository.save(pedido);
			for (Item it : pedido.getItens()) {
				it.setPrecoProduto(produtoRepository.findOne(it.getProduto().getId()).getPreco());
				it.setPedido(pedido);
			}
		} else {
			
		}
			


		itemRepository.save(pedido.getItens());
		return pedido;
	}

	public Pedido atualizar(Integer id, Pedido pedidoUpdate) {
		Pedido pedido = buscarPorId(id);
		for (Item it : pedidoUpdate.getItens()) {
			
				
				it.setPrecoProduto(produtoRepository.findOne(it.getProduto().getId()).getPreco());
				pedido.getItens().add(it);
				it.setPedido(pedido);
			

		}
		pedido.setStatus(pedidoUpdate.getStatus());
		itemRepository.save(pedido.getItens());
		pedidoRepository.save(pedido);
		return pedido;
	}

	public boolean CancelarPedido(Pedido ped) {
		if (ped.getIsCancelado()) {
			ped.setStatus(StatusPedido.CANCELADO);
			for (Item it : ped.getItens()) {
				it.setStatusItem(StatusItem.CANCELADO);
			}
			return true;
		}
		return false;
	}

}
