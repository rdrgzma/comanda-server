package com.comanda.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.models.Produto;
import com.comanda.server.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto buscarPorId(Integer id) {
		return produtoRepository.findOne(id);
	}
	
	public List<Produto> buscarTodos(){
		return produtoRepository.findAll();		
	}

}
