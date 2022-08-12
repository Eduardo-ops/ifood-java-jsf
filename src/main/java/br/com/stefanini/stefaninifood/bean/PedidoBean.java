package br.com.stefanini.stefaninifood.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.stefanini.stefaninifood.dao.DAO;
import br.com.stefanini.stefaninifood.modelo.Pedido;
import br.com.stefanini.stefaninifood.modelo.Produto;

@ManagedBean
@ViewScoped
public class PedidoBean {

	private Pedido pedido = new Pedido();
	private Integer produtoId;

	public List<Pedido> getPedidos() {
		return new DAO<Pedido>(Pedido.class).listaTodos();
	}

	public String gravarPedido() {
		if (this.pedido.getProdutos().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("produto",
					new FacesMessage("Cada pedido deve conter pelo menos um produto."));
		} else {
			new DAO<Pedido>(Pedido.class).adiciona(pedido);
			this.pedido = new Pedido();
			return "pedidos?faces-redirect=true";
		}

		return "";
	}

	public void gravarAlteracaoDePedido() {

		if (this.pedido.getId() == null) {
			throw new RuntimeException("O pedido não pode ser cadastrado sem nenhum dado informado.");
		} else {
			new DAO<Pedido>(Pedido.class).atualiza(pedido);
			this.pedido = new Pedido();
		}
	}

	public void removeItemDoPedido(Produto produto) {
		this.pedido.removeProduto(produto);
	}

	public void alterarPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void cancelarAlteracaoDePedido() {
		this.pedido = new Pedido();
	}

	public void removerPedido(Pedido pedido) {
		new DAO<Pedido>(Pedido.class).remove(pedido);
	}

	public List<Produto> getProdutos() {
		return new DAO<Produto>(Produto.class).listaTodos();
	}

	public void gravarItem() {
		Produto produto = new DAO<Produto>(Produto.class).bucaPorId(produtoId);
		this.pedido.adicionarProduto(produto);
	}

	public List<Produto> getItensDoPedido() {
		return this.pedido.getProdutos();
	}

	public String visualizarPedidos() {
		return "pedidos?faces-redirect=true";
	}

	public String formPedido() {
		return "cadastroPedido?faces-redirect=true";
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

}
