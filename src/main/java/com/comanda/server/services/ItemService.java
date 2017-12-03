package com.comanda.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.exception.ObjetoNaoEncontradoException;
import com.comanda.server.models.Item;
import com.comanda.server.models.Pedido;
import com.comanda.server.repositories.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public Item buscarPorID(Integer id) {	
		Item it = itemRepository.findOne(id);
		if(it == null) {
			throw new ObjetoNaoEncontradoException(Pedido.class.getName()+" não encontrado Id: "
					+ id);
		}
		return it;	
	}
	
	public List<Item> buscarTodos(){
		List<Item> itens = itemRepository.findAll();	
		if(itens == null) {
			throw new ObjetoNaoEncontradoException("Itens não encontrados");
		}
		return itens;
	}

}
