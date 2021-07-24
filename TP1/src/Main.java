import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import helper.Util;
import models.Cliente;
import models.Produto;

public class Main {

	private static Scanner ler = new Scanner(System.in);
	private static ArrayList<Produto> produtos;
	private static ArrayList<Cliente> clientes;

	public static void main(String[] args) {

		produtos = new ArrayList<Produto>();
		produtos.add(new Produto("Camisa", "Manga longa", 19.99, 5.0, 10));
		produtos.add(new Produto("Short", "Praia", 19.99, 5.0, 0));
		clientes = new ArrayList<Cliente>();
		Main.menu();
	}

	private static void menu() {
		System.out.println("==========================================");
		System.out.println("============== Bem-vindo(a) ==============");
		System.out.println("============ Lojinha humilde =============");
		System.out.println("==========================================");
		System.out.println("1- Cadastro de novo cliente ");
		System.out.println("2- Busca por cliente ");
		System.out.println("3- Cadastro de novo produto ");
		System.out.println("4- Busca por produto ");
		System.out.println("5- Cadastro de venda ");
		System.out.println("6- Mostrar produtos em estoque ");
		System.out.println("7- Sair do sistema ");
		int opcao = 0;
		try {
			opcao = Integer.parseInt(Main.ler.nextLine());
		} catch (InputMismatchException e) {
			Main.menu();
		} catch (NumberFormatException f) {
			Main.menu();
		}
		switch (opcao) {
		case 1:
			Main.cadastrarCliente();
			break;
//		case 2:
//			Main.buscarCliente();
//			break;
		case 3:
			Main.cadastrarProduto();
			break;
//		case 4:
//			Main.buscarProduto();
//			break;
//		case 5:
//			Main.cadastrarVenda();
//			break;
		case 6:
			Main.listarProduto();
			break;
		case 7:
			System.out.println("Volte sempre!!");
			Util.pausar(2);
			System.exit(0);

		default:
			System.out.println("Opção inválida =( ");
			Util.pausar(2);
			Main.menu();
			break;
		}
	}

	private static void cadastrarProduto() {
		System.out.println("Cadastro de Produto");
		System.out.println("===================");

		System.out.println("Informe o nome do produto: ");
		String nome = Main.ler.nextLine();

		System.out.println("Informe a descrição do produto: ");
		String descricao = Main.ler.nextLine();

		System.out.println("Informe o valor do produto");
		Double valor = Main.ler.nextDouble();

		System.out.println("Informe a porcentagem de lucro do produto");
		Double porcentagemLucro = Main.ler.nextDouble();

		System.out.println("Informe a quantidade em estoque do produto");
		int qtdEstoque = Main.ler.nextInt();

		Produto produto = new Produto(nome, descricao, valor, porcentagemLucro, qtdEstoque);
		Main.produtos.add(produto);
		System.out.println("O produto " + produto.getNome() + " foi cadastrado com sucesso");
		Util.pausar(2);
		Main.menu();
	}

	private static void listarProduto() {
		if (Main.produtos.size() > 0) {
			for (Produto p : Main.produtos) {
				if (p.getQtdEstoque() > 0) {
					System.out.println(p);
					System.out.println();
				}
			}
		} else {
			System.out.println("Ainda não existem produtos cadastrados");
		}
		Util.pausar(2);
		Main.menu();
	}
	
	private static void cadastrarCliente() {
		System.out.println("Cadastro de Cliente");
		System.out.println("===================");

		System.out.println("Informe o nome do cliente: ");
		String nome = Main.ler.nextLine();

		System.out.println("Informe o telefone do cliente(Apenas números): ");
		String telefone = Main.ler.nextLine();

		System.out.println("Informe o endereço do cliente");
		String endereco = Main.ler.nextLine();

		
		Cliente cliente = new Cliente(nome,telefone,endereco);
		Main.clientes.add(cliente);
		System.out.println("O cliente " + cliente.getNome() + " foi cadastrado com sucesso");
		Util.pausar(2);
		Main.menu();
	}

}
