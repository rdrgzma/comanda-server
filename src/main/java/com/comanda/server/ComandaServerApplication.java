package com.comanda.server;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

@SpringBootApplication
public class ComandaServerApplication implements CommandLineRunner{
	
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(100.0, 1, StatusPedido.ABERTO, sdf.parse("02/12/2017 22:22"), cli1, est1);
		Pedido ped2 = new Pedido(10.0,2, StatusPedido.ATENDIMENTO,sdf.parse("02/12/2017 22:23"),cli1,est1);
		Pedido ped3 = new Pedido(45.50,3, StatusPedido.ATENDIMENTO,sdf.parse("02/12/2017 21:00"),cli2,est1);
		
		Pedido ped4 = new Pedido(50.0,4, StatusPedido.ENCERRADO,sdf.parse("02/12/2017 20:00"),cli1,est2);
		Pedido ped5 = new Pedido(23.0,5, StatusPedido.FINALIZADO,new Date(),cli2,est2);
	
		
		pedidoRepository.save(Arrays.asList(ped1,ped2,ped3, ped4,ped5));
		
		Item it1 = new Item(prod1,ped1, 2, 2*prod1.getPreco());
		Item it2 = new Item(prod2,ped2,1,1*prod2.getPreco());
		Item it3 = new Item(prod3,ped3,5,5*prod3.getPreco());
		
		Item it4 = new Item(prod4,ped4,3,3*prod4.getPreco());
		Item it5 = new Item(prod5,ped5,1,1*prod5.getPreco());
		
		
		
		ped1.getItens().addAll(Arrays.asList(it1,it2));
		ped2.getItens().addAll(Arrays.asList(it3));
		ped4.getItens().addAll(Arrays.asList(it4));
		ped5.getItens().addAll(Arrays.asList(it5));
	
		prod1.getItens().addAll(Arrays.asList(it1));
		prod2.getItens().addAll(Arrays.asList(it2));
		prod3.getItens().addAll(Arrays.asList(it3));
		prod4.getItens().addAll(Arrays.asList(it4));
		prod5.getItens().addAll(Arrays.asList(it5));
		
		itemRepository.save(Arrays.asList(it1,it2,it3,it4,it5));
		

		
		
		
	}
}
