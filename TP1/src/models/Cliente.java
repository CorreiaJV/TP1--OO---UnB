package models;

import java.util.ArrayList;

import helper.Util;

public class Cliente {
	private static int contador = 1;
	private Integer ID;
	private String nome;
	private String endereco;
	private String telefone;
	

	public Cliente(String nome, String endereco, String telefone) {
		this.ID = Cliente.contador;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		
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
	
	
	
	public String toString() {
		return "\nID: " + this.getID() + "\nNome: " + this.getNome() + "\nEndereco: " + this.getEndereco()
				+ "\nTelefone: " + Util.phoneNumberFormat(this.getTelefone());

	}
	
	

}
