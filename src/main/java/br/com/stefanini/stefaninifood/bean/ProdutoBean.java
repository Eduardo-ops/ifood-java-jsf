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

	public String gravarProduto() {
		new DAO<Produto>(Produto.class).adiciona(this.produto);
		this.produto = new Produto();
		return "produtos?faces-redirect=true";
	}

	public void gravarAlteracaoDeProduto() {

		if (this.produto.getId() == null) {
			throw new RuntimeException("O produto não pode ser cadastrado sem nenhum dado informado.");
		} else {
			new DAO<Produto>(Produto.class).atualiza(produto);
			this.produto = new Produto();
		}
	}

	public void alterarProduto(Produto produto) {
		this.produto = produto;
	}

	public void cancelarAlteracaoDeProduto() {
		this.produto = new Produto();
	}

	public void removerProduto(Produto produto) {
		new DAO<Produto>(Produto.class).remove(produto);
	}

	public String visualizarProdutos() {
		return "produtos?faces-redirect=true";
	}

	public String voltarAoHome() {
		return "home?faces-redirect=true";
	}

	public String formProduto() {
		System.out.println("Rota chamada.");
		return "cadastroProduto?faces-redirect=true";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
