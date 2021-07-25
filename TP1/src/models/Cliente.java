package models;

import java.util.ArrayList;

import helper.Util;

public class Cliente {
	private static int contador = 1;
	private Integer ID;
	private String nome;
	private String endereco;
	private String telefone;
	private ArrayList<Produto> compras;

	public Cliente(String nome, String endereco, String telefone) {
		this.ID = Cliente.contador;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.compras= new ArrayList<Produto>();
		Cliente.contador++;
	}

	public int getID() {
		return ID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public ArrayList<Produto> getCompras() {
		return this.compras;
	}
	public void AddCompra(Produto produto) {
		this.compras.add(produto);
		
	}
	public void printVendas() {
		System.out.println("\nID: " + this.getID() +"\nNome: " + this.getNome() + "\nVendas: [");
		for(Produto p: this.compras) {
			p.printProdutoVendido();
		}
		System.out.println("]");
	}
	
	public String toString() {
		return "\nID: " + this.getID() + "\nNome: " + this.getNome() + "\nEndereco: " + this.getEndereco()
				+ "\nTelefone: " + Util.phoneNumberFormat(this.getTelefone());

	}

}
