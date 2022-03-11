package com.example.demo.entitys;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.entitys.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
	private Instant instante;
	
	private Integer pedidoStatus;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private User cliente;
	
	public Pedido() {
		
	}

	public Pedido(Long id, Instant instante,PedidoStatus pedidoStatus, User cliente) {
		super();
		this.id = id;
		this.instante = instante;
		setPedidoStatus(pedidoStatus);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInstante() {
		return instante;
	}

	public void setInstante(Instant instante) {
		this.instante = instante;
		
	}
	
	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valorPedido(pedidoStatus);
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if(pedidoStatus != null) {
		this.pedidoStatus = pedidoStatus.getCode();}
	}

	public User getCliente() {
		return cliente;
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
	

}
