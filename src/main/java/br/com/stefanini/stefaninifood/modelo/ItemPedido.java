package br.com.stefanini.stefaninifood.modelo;

import javax.persistence.Entity;

@Entity
public class ItemPedido {

	private String produto;
	private int quantidade;
	private float total;

	public ItemPedido() {

	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
