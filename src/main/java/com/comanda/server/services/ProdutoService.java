package com.comanda.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.exception.ObjetoNaoEncontradoException;
import com.comanda.server.models.Produto;
import com.comanda.server.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto buscarPorId(Integer id) {
		Produto prod = produtoRepository.findOne(id);
		if(prod == null) {
			throw new ObjetoNaoEncontradoException(Produto.class.getName()+" não encontrado Id: "
					+ id);
		}
		return prod;
	}
	
	public List<Produto> buscarTodos(){
		List<Produto> list = produtoRepository.findAll();
		if(list == null) {
			throw new ObjetoNaoEncontradoException("Produtos não encontrados");
		}
		return list;
	}
	
	public Produto salvar(Produto produto) {
		produto.setId(null);
		return produtoRepository.save(produto);
	}

}
