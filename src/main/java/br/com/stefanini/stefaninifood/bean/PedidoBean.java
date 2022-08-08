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
		return null;
	}

	public void gravarPedido() {

	}

	public void alterarPedido() {

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
