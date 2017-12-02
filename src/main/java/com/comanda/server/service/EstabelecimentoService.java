package com.comanda.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.models.Estabelecimento;
import com.comanda.server.repositories.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	public Estabelecimento buscar(Integer id) {
		return estabelecimentoRepository.findOne(id);
	}
	

}
