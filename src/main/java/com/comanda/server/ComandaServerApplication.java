package com.comanda.server;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.comanda.server.models.Cliente;
import com.comanda.server.models.Estabelecimento;
import com.comanda.server.models.Produto;
import com.comanda.server.repositories.ClienteRepository;
import com.comanda.server.repositories.EstabelecimentoRepository;
import com.comanda.server.repositories.ProdutoRepository;

@SpringBootApplication
public class ComandaServerApplication implements CommandLineRunner{
	
	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(ComandaServerApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Cliente cli1 = new Cliente("João da Silva", "joao@email");
		Cliente cli2 = new Cliente("Jozé da Rocha", "ze@email");
		Cliente cli3 = new Cliente("Maria das Dores", "maria@email");
	
		Estabelecimento est1 = new Estabelecimento("Buteco 1", "bureco1@email");
		Estabelecimento est2 = new Estabelecimento("Buteco 2", "bureco2@email");
		
		Produto prod1 = new Produto("Cerveja", 15.0);
		Produto prod2 = new Produto("Refrigerente", 10.0);
		Produto prod3 = new Produto("Batata-Frita", 25.0);

		Produto prod4 = new Produto("Água", 10.0);
		Produto prod5 = new Produto("Xis-Salada", 20.0);
		
		est1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
		est2.getProdutos().addAll(Arrays.asList(prod4,prod5));
		
		prod1.getEstabelecimentos().addAll(Arrays.asList(est1));
		prod2.getEstabelecimentos().addAll(Arrays.asList(est1));
		prod3.getEstabelecimentos().addAll(Arrays.asList(est1));

		prod4.getEstabelecimentos().addAll(Arrays.asList(est2));
		prod5.getEstabelecimentos().addAll(Arrays.asList(est2));

		clienteRepository.save(Arrays.asList(cli1,cli2,cli3));
		estabelecimentoRepository.save(Arrays.asList(est1,est2));
		produtoRepository.save(Arrays.asList(prod1,prod2,prod3,prod4,prod5));
		
	}
}
