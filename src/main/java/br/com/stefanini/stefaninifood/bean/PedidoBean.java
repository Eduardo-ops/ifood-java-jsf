package br.com.stefanini.stefaninifood.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.stefanini.stefaninifood.dao.DAO;
import br.com.stefanini.stefaninifood.modelo.Pedido;
import br.com.stefanini.stefaninifood.modelo.Produto;

@ManagedBean
@ViewScoped
public class PedidoBean {

	private Pedido pedido = new Pedido();
	private Integer itemPedidoId;

	public List<Pedido> getPedidos() {
		return new DAO<Pedido>(Pedido.class).listaTodos();
	}

	public void gravarPedido() {
		new DAO<Pedido>(Pedido.class).adiciona(pedido);
		this.pedido = new Pedido();
	}

	public void gravarAlteracaoDePedido() {

		if (this.pedido.getId() == null) {
			throw new RuntimeException("O pedido não pode ser cadastrado sem nenhum dado informado.");
		} else {
			new DAO<Pedido>(Pedido.class).atualiza(pedido);
			this.pedido = new Pedido();
		}
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getItemPedidoId() {
		return itemPedidoId;
	}

	public void setItemPedidoId(Integer itemPedidoId) {
		this.itemPedidoId = itemPedidoId;
	}

}
