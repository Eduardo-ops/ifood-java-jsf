package br.com.stefanini.stefaninifood.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue
	private Integer id;

	private String tipoDePagamento;
	private String endereco;
	private float precoTotal;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Produto> produtos = new ArrayList<Produto>();

	public Pedido() {

	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void adicionarProduto(Produto produto) {
		this.produtos.add(produto);
		this.precoTotal = this.precoTotal + produto.getValor();
	}

	public void removeProduto(Produto produto) {
		this.produtos.remove(produto);
		this.precoTotal = this.precoTotal - produto.getValor();
	}

	public void calculaPrecoTotal(Produto produto) {
		this.precoTotal = this.precoTotal + produto.getValor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoDePagamento() {
		return tipoDePagamento;
	}

	public void setTipoDePagamento(String tipoDePagamento) {
		this.tipoDePagamento = tipoDePagamento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
