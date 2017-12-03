package com.comanda.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.comanda.server.exception.DataIntegrityException;
import com.comanda.server.exception.ObjetoNaoEncontradoException;
import com.comanda.server.models.Estabelecimento;
import com.comanda.server.repositories.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	public Estabelecimento buscarPorId(Integer id) {
		Estabelecimento est = estabelecimentoRepository.findOne(id);
		if(est == null) {
			throw new ObjetoNaoEncontradoException(Estabelecimento.class.getName()+" não encontrado Id: "
					+ id);
		}
		
		return est;
	}
	
	public List<Estabelecimento> buscarTodos(){
		List<Estabelecimento> est = estabelecimentoRepository.findAll();	
		if(est == null) {
			throw new ObjetoNaoEncontradoException("Estabelecimentos não encontrados");
		}
		
		return est;
	}
	
	public Estabelecimento salvar(Estabelecimento estabelecimento) {
		estabelecimento.setId(null);
		return estabelecimentoRepository.save(estabelecimento);
	}

	public  void apagar(Integer id) {
		buscarPorId(id);
		try {
			estabelecimentoRepository.delete(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Se deseja excluir este estabelecimento exclua primeiro os produtos cadastrados.");
		}
		
		
	}

}
