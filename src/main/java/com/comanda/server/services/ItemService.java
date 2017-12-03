package com.comanda.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.models.Item;
import com.comanda.server.repositories.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public Item buscarPorID(Integer id) {
		
		return itemRepository.findOne(id);
		
	}
	
	public List<Item> buscarTodos(){
		return itemRepository.findAll();
	}

}
