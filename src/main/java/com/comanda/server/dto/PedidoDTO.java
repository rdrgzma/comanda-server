package com.comanda.server.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.comanda.server.models.Item;
import com.comanda.server.models.Pedido;

public class PedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer estabelecimento_id;
	private Integer cliente_id;
	private int mesa;
	private Set<Item> itens = new HashSet<>();
	private String status;
	private Double total;

	
	public PedidoDTO() {
		
	}

	public PedidoDTO(Pedido pedido) {
		super();
		this.id = pedido.getId();
		this.estabelecimento_id = pedido.getEstabelecimento().getId();
		this.cliente_id = pedido.getCliente().getId();
		this.mesa = pedido.getMesa();
		this.itens = pedido.getItens();
		this.status = pedido.getStatus().getStatus();
		this.total = pedido.getTotal();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEstabelecimento_id() {
		return estabelecimento_id;
	}

	public void setEstabelecimento_id(Integer estabelecimento_id) {
		this.estabelecimento_id = estabelecimento_id;
	}

	public Integer getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
