package br.com.stefanini.stefaninifood.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.stefanini.stefaninifood.modelo.ItemPedido;

@ManagedBean
@ViewScoped
public class ItemPedidoBean {

	private ItemPedido itemPedido = new ItemPedido();

	public List<ItemPedido> getItensDePedidos() {
		return null;
	}

	public void gravarItemDePedido() {

	}

	public void alterarItemDePedido() {

	}

	public void removerItemDePedido() {

	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

}
