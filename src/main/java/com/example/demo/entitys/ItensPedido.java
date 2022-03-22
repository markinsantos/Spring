package com.example.demo.entitys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.example.demo.entitys.pk.PedidoItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItensPedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PedidoItemPk id = new PedidoItemPk();
	
	private Integer quantidade;
	private Double preco;
	
	public ItensPedido() {
		
	}

	public ItensPedido(Pedido pedido,Produto produto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido peddo) {
		id.setPedido(peddo);
		
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
		
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double getSubTotal() {
		return preco * quantidade;
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
		ItensPedido other = (ItensPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
