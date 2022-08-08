package br.com.stefanini.stefaninifood.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.stefanini.stefaninifood.dao.DAO;
import br.com.stefanini.stefaninifood.modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto produto = new Produto();

	public List<Produto> getProdutos() {
		return new DAO<Produto>(Produto.class).listaTodos();
	}

	public void gravarProduto() {
		new DAO<Produto>(Produto.class).adiciona(this.produto);

		this.produto = new Produto();
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
