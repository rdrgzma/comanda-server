package com.comanda.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.exception.ObjetoNaoEncontradoException;
import com.comanda.server.models.Cliente;
import com.comanda.server.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente buscarPorID(Integer id) {
		Cliente cli = clienteRepository.findOne(id);
		if(cli == null) {
			throw new ObjetoNaoEncontradoException("Clientes não encontrados");
		}
		return cli;
		
	}
	
	public List<Cliente> buscarTodos(){
		List<Cliente> cli = clienteRepository.findAll();
		if(cli == null) {
			throw new ObjetoNaoEncontradoException("Clientes não encontrados");
		}
		return cli;
	}

}
