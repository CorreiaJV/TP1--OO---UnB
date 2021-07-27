package models;

import helper.Util;

public class Venda {

	private Produto produto;
	private Cliente cliente;
	private int qtdVendida;
	
	public Venda(Produto produto, Cliente cliente, int qtdVendida) {
		super();
		this.produto = produto;
		this.cliente = cliente;
		this.qtdVendida = qtdVendida;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getQtdVendida() {
		return qtdVendida;
	}
	public void setQtdVendida(int qtdVendida) {
		this.qtdVendida = qtdVendida;
	}
	public String toString() {
		return "\nCliente: " + "ID: "+ this.cliente.getID() + " Nome: " + this.cliente.getNome() + "\nProduto: "+ "ID: "+ this.produto.getId() +  this.produto.getNome() 
				+ "\nQuantidade vendida " + this.getQtdVendida();

	}
	
	
	
}
