package com.comanda.server.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comanda.server.exception.ObjetoNaoEncontradoException;
import com.comanda.server.models.Produto;
import com.comanda.server.service.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
		
		Produto prod = produtoService.buscarPorId(id);
		if(prod == null) {
			throw new ObjetoNaoEncontradoException(Produto.class.getName()+" não encontrado Id: "
					+ id);
		}
		 return ResponseEntity.ok().body(prod);

	}
	
	@RequestMapping(value="/todos", method=RequestMethod.GET)
	public ResponseEntity<?> buscarTodos() {
		List<Produto> est = produtoService.buscarTodos();
		
		if(est == null) {
			throw new ObjetoNaoEncontradoException("Produtos não encontrados");
		}
		return ResponseEntity.ok().body(est);	
	}

}
