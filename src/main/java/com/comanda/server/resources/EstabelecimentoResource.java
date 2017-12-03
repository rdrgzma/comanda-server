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

import com.comanda.server.exception.ObjetoNaoEncontradoException;
import com.comanda.server.models.Estabelecimento;
import com.comanda.server.services.EstabelecimentoService;

@RestController
@RequestMapping(value="/estabelecimentos")
public class EstabelecimentoResource {
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorID(@PathVariable Integer id) {
		Estabelecimento est = estabelecimentoService.buscarPorId(id);
		
		if(est == null) {
			throw new ObjetoNaoEncontradoException(Estabelecimento.class.getName()+" não encontrado Id: "
					+ id);
		}
		return ResponseEntity.ok().body(est);	
	}
	
	@RequestMapping(value="/todos", method=RequestMethod.GET)
	public ResponseEntity<?> buscarTodos() {
		List<Estabelecimento> est = estabelecimentoService.buscarTodos();
		
		if(est == null) {
			throw new ObjetoNaoEncontradoException("Estabelecimentos não encontrados");
		}
		return ResponseEntity.ok().body(est);	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Estabelecimento estabelecimento){
		estabelecimento = estabelecimentoService.salvar(estabelecimento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estabelecimento.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
