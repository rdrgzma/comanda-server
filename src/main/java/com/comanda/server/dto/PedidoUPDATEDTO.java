package com.comanda.server.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.comanda.server.models.Item;
import com.comanda.server.models.Pedido;

public class PedidoUPDATEDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private Set<Item> itens = new HashSet<>();
	private String status;


	
	public PedidoUPDATEDTO() {
		
	}

	public PedidoUPDATEDTO(Pedido pedido) {
		super();
		this.id = pedido.getId();
		this.itens = pedido.getItens();
		this.status = pedido.getStatus().getStatus();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Item> getItens() {
		return itens;
	}

	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
