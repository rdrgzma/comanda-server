package com.comanda.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.models.Cliente;
import com.comanda.server.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente buscarPorID(Integer id) {
		
		return clienteRepository.findOne(id);
		
	}
	
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}

}
