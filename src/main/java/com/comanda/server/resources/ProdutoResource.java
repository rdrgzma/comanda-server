package com.comanda.server.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.comanda.server.models.Produto;
import com.comanda.server.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id){	
		Produto prod = produtoService.buscarPorId(id);
		 return ResponseEntity.ok().body(prod);

	}
	
	@RequestMapping(value="/todos", method=RequestMethod.GET)
	public ResponseEntity<?> buscarTodos() {
		List<Produto> est = produtoService.buscarTodos();
		return ResponseEntity.ok().body(est);	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Produto produto){
		produto = produtoService.salvar(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
