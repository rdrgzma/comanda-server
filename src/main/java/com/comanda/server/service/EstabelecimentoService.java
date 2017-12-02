package com.comanda.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.models.Estabelecimento;
import com.comanda.server.repositories.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	public Estabelecimento buscarPorId(Integer id) {
		return estabelecimentoRepository.findOne(id);
	}
	
	public List<Estabelecimento> buscarTodos(){
		return estabelecimentoRepository.findAll();
	}

}
