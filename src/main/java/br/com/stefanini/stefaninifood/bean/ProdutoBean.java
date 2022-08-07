package br.com.stefanini.stefaninifood.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.stefanini.stefaninifood.modelo.Pedido;
import br.com.stefanini.stefaninifood.modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto produto = new Produto();

	public List<Pedido> getProdutos() {
		return null;
	}

	public void gravarProduto() {

	}

	public void alterarProduto() {

	}

	public void removerProduto() {

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
