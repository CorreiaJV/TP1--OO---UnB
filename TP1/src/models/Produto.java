package models;

import helper.Util;

public class Produto {
	private static int aux = 1;
	private int id;
	private String nome;
	private String descricao;
	private Double valor;
	private Double porcentagemLucro;
	private int qtdEstoque;

	public Produto(String nome, String descricao, Double valor, Double porcentagemLucro, int qtdEstoque) {
		this.id = Produto.aux;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.porcentagemLucro = porcentagemLucro;
		this.qtdEstoque = qtdEstoque;
		this.aux++;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getPorcentagemLucro() {
		return porcentagemLucro;
	}

	public void setPorcentagemLucro(Double porcentagemLucro) {
		this.porcentagemLucro = porcentagemLucro;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String toString() {
		return "\nID: " + this.getId() + "\nNome: " + this.getNome() + "\nNome: " + this.getDescricao() + "\nValor: "
				+ Util.doubleParaString(this.getValor()) + "\nPorcentagem de Lucro: " + this.getPorcentagemLucro() +"%"
				+ "\nQtd em Estoque: " + this.getQtdEstoque();

	}

}
