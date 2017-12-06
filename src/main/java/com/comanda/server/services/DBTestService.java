package com.comanda.server.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comanda.server.enums.StatusPedido;
import com.comanda.server.models.Cliente;
import com.comanda.server.models.Estabelecimento;
import com.comanda.server.models.Item;
import com.comanda.server.models.Pedido;
import com.comanda.server.models.Produto;
import com.comanda.server.repositories.ClienteRepository;
import com.comanda.server.repositories.EstabelecimentoRepository;
import com.comanda.server.repositories.ItemRepository;
import com.comanda.server.repositories.PedidoRepository;
import com.comanda.server.repositories.ProdutoRepository;

@Service
public class DBTestService {
	
	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	public void instantiateTestDatabase() throws ParseException {
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(1, StatusPedido.ABERTO, sdf.parse("02/12/2017 22:22"), cli1, est1);
		Pedido ped2 = new Pedido(2, StatusPedido.ATENDIMENTO,sdf.parse("02/12/2017 22:23"),cli1,est1);
		Pedido ped3 = new Pedido(3, StatusPedido.ATENDIMENTO,sdf.parse("02/12/2017 21:00"),cli2,est1);
		
		Pedido ped4 = new Pedido(4, StatusPedido.ENCERRADO,sdf.parse("02/12/2017 20:00"),cli1,est2);
		Pedido ped5 = new Pedido(5, StatusPedido.FINALIZADO,new Date(),cli2,est2);
	
		Pedido ped6 = new Pedido(100, StatusPedido.ATENDIMENTO,sdf.parse("02/12/2017 21:00"),cli2,est1);
		
		
		Item it1 = new Item(prod1,ped1,2);
		Item it2 = new Item(prod2,ped1,1);
		Item it3 = new Item(prod3,ped3,5);
		
		Item it4 = new Item(prod4,ped4,3);
		Item it5 = new Item(prod5,ped5,1);
		
		Item it6 = new Item(prod1,ped6,10);
		
		
		
		ped1.getItens().addAll(Arrays.asList(it1,it2));
		ped2.getItens().addAll(Arrays.asList(it3));
		ped4.getItens().addAll(Arrays.asList(it4));
		ped5.getItens().addAll(Arrays.asList(it5));
		ped6.getItens().addAll(Arrays.asList(it6));
	
		prod1.getItens().addAll(Arrays.asList(it1,it6));
		prod2.getItens().addAll(Arrays.asList(it2));
		prod3.getItens().addAll(Arrays.asList(it3));
		prod4.getItens().addAll(Arrays.asList(it4));
		prod5.getItens().addAll(Arrays.asList(it5));
		
		pedidoRepository.save(Arrays.asList(ped1,ped2,ped3, ped4,ped5,ped6));
		
		itemRepository.save(Arrays.asList(it1,it2,it3,it4,it5,it6));
		

	}

}
