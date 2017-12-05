package com.comanda.server.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.comanda.server.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	private int mesa;
	private String status;
	
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="estabelecimento_id")
	private Estabelecimento estabelecimento;

	@OneToMany(mappedBy="pedido")
	private Set<Item> itens = new HashSet<>();
	
	public Pedido(Integer id, int mesa, StatusPedido status, Date data) {
		super();
		this.id = id;
		this.mesa = mesa;
		this.status = status.getStatus();
		this.data = data;
	}
	
	public Pedido(  int mesa, StatusPedido status, Date data) {
		super();
		this.mesa = mesa;
		this.status = status.getStatus();
		this.data = data;
	}
	
	

	public Pedido(int mesa, StatusPedido status, Date data, Cliente cliente, Estabelecimento estabelecimento) {
		super();
		this.mesa = mesa;
		this.status = status.getStatus();
		this.data = data;
		this.cliente = cliente;
		this.estabelecimento = estabelecimento;
		
		
	}

	public Pedido() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorTotal() {
		double total = 0.0;
		 for(Item it: itens) {
			 total += it.getValorTotal();
		 }	
		return total;
	}
	

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public StatusPedido getStatus() {
		return StatusPedido.toEnumString(status);
	}

	public void setStatus(StatusPedido status) {
		this.status = status.getStatus();
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Set<Item> getItens() {
		return itens;
	}

	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
