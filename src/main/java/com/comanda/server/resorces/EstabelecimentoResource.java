package com.comanda.server.resorces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comanda.server.models.Estabelecimento;

@RestController
@RequestMapping(value="/estabelecimentos")
public class EstabelecimentoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Estabelecimento> listar() {
		
		Estabelecimento est1 = new Estabelecimento(1,"nome","email@email");
		Estabelecimento est2 = new Estabelecimento(2,"nome2","email2@email");
		
		List<Estabelecimento> lista = new ArrayList<>();
		lista.add(est1);
		lista.add(est2);
	
		return lista;
		
	}

}
