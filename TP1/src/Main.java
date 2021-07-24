import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Optional;
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
		clientes.add(new Cliente("Joao", "Rua 22", "61923457654"));
		clientes.add(new Cliente("Jonas", "Rua 22 bloco 54", "11934576540"));
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
			System.out.println("Opção Inválida");
			Util.pausar(2);
			Main.menu();
		} catch (NumberFormatException f) {
			System.out.println("Opção Inválida");

			Main.menu();
		}
		switch (opcao) {
		case 1:
			Main.cadastrarCliente();
			break;
		case 2:
			Main.buscarCliente();
			break;
		case 3:
			Main.cadastrarProduto();
			break;
		case 4:
			Main.buscarProduto();
			break;
//		case 5:
//			Main.cadastrarVenda();
//			break;
		case 6:
			Main.listarProdutos();
			break;
		case 7:
			System.out.println("Volte sempre!!");
			Util.pausar(2);
			System.exit(0);

		default:
			System.out.println("Opção inválida");
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

	private static void listarProdutos() {
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

		System.out.println("Informe o telefone do cliente com ddd(Apenas números): ");
		String telefone = Main.ler.nextLine();

		System.out.println("Informe o endereço do cliente");
		String endereco = Main.ler.nextLine();

		Cliente cliente = new Cliente(nome, telefone, endereco);
		Main.clientes.add(cliente);
		System.out.println("O cliente " + cliente.getNome() + " foi cadastrado com sucesso");
		Util.pausar(2);
		Main.menu();
	}

	private static void listarClientes() {
		if (Main.clientes.size() > 0) {
			for (Cliente p : Main.clientes) {

				System.out.println(p);
				System.out.println();

			}
		} else {
			System.out.println("Ainda não existem produtos cadastrados");
		}
		Util.pausar(2);
		Main.menu();
	}

	private static void buscarCliente() {
		System.out.println("Digite o nome do Cliente");
		String nome = Main.ler.nextLine();
		try {

			Optional<Cliente> x = Main.clientes.stream()
					.filter(p -> p.getNome().toUpperCase().equals(nome.toUpperCase())).findFirst();

			System.out.println(x.get());

			System.out.println("\nDeseja editar os dados do cliente?");
			System.out.println("1- Sim");
			System.out.println("2- Não");

			int aux = Main.ler.nextInt();
			ler.nextLine();

			if (aux == 1) {
				Main.editarCliente(x.get());
			} else if (aux == 2) {

				Main.menu();
			} else {
				System.out.println("Opção inválida");
				Util.pausar(2);
				Main.menu();
			}

		} catch (Exception e) {
			System.out.println("Cliente não encontrado!");
			Util.pausar(2);
			Main.menu();
		}

	}

	private static void editarCliente(Cliente cliente) {

		System.out.println("1- Editar Nome ");
		System.out.println("2- Editar endereco ");
		System.out.println("3- Editar telefone ");
		System.out.println("4- Editar tudo ");

		int aux = Main.ler.nextInt();
		ler.nextLine();
		switch (aux) {
		case 1:
			System.out.println("Informe o nome do cliente: ");
			String nome = Main.ler.nextLine();
			cliente.setNome(nome);
			System.out.println("Campo alterado com sucesso");
			Util.pausar(2);
			Main.menu();
			break;
		case 2:
			System.out.println("Informe o endereco do cliente: ");
			String endereco = Main.ler.nextLine();
			cliente.setEndereco(endereco);
			System.out.println("Campo alterado com sucesso");
			Util.pausar(2);
			Main.menu();
			break;
		case 3:
			System.out.println("Informe o telefone do cliente com ddd(Apenas números): ");
			String telefone = Main.ler.nextLine();
			cliente.setTelefone(telefone);
			System.out.println("Campo alterado com sucesso");
			Util.pausar(2);
			Main.menu();
			break;
		case 4:
			System.out.println("Informe o nome do cliente: ");
			nome = Main.ler.nextLine();

			System.out.println("Informe o telefone do cliente com ddd(Apenas números): ");
			telefone = Main.ler.nextLine();

			System.out.println("Informe o endereço do cliente");
			endereco = Main.ler.nextLine();
			cliente.setNome(nome);
			cliente.setEndereco(endereco);
			cliente.setTelefone(telefone);
			System.out.println("Cliente alterado com sucesso");
			Util.pausar(2);
			Main.menu();

			break;
		default:
			System.out.println("Opção inválida");
			Util.pausar(2);
			Main.editarCliente(cliente);
			break;
		}

	}

	private static void buscarProduto() {
		System.out.println("\nDigite o nome do produto");
		String nome = Main.ler.nextLine();
		try {

			Optional<Produto> x = Main.produtos.stream()
					.filter(p -> p.getNome().toUpperCase().equals(nome.toUpperCase())).findFirst();

			System.out.println(x.get());

			System.out.println("\nDeseja editar os dados do produto?");
			System.out.println("1- Sim");
			System.out.println("2- Não");

			int aux = Main.ler.nextInt();
			ler.nextLine();

			if (aux == 1) {
				Main.editarProduto(x.get());
			} else if (aux == 2) {

				Main.menu();
			} else {
				System.out.println("Opção inválida");
				Util.pausar(2);
				Main.menu();
			}

		} catch (Exception e) {
			System.out.println("Produto não encontrado!");
		}

	}

	private static void editarProduto(Produto produto) {

		System.out.println("1- Editar Nome ");
		System.out.println("2- Editar Descrição ");
		System.out.println("3- Editar Valor ");
		System.out.println("4- Editar porcentagem de lucro ");
		System.out.println("5- Editar quantidade em estoque");
		System.out.println("6- Editar tudo");

		int aux = Main.ler.nextInt();
		ler.nextLine();
		switch (aux) {
		case 1:
			System.out.println("Informe o nome do produto: ");
			String nome = Main.ler.nextLine();
			produto.setNome(nome);
			System.out.println("Campo alterado com sucesso");
			Util.pausar(2);
			Main.menu();
			break;
		case 2:
			System.out.println("Informe a descrição do produto: ");
			String descricao = Main.ler.nextLine();
			produto.setDescricao(descricao);
			System.out.println("Campo alterado com sucesso");
			Util.pausar(2);
			Main.menu();
			break;
		case 3:
			System.out.println("Informe o valor do produto: ");
			Double valor = Main.ler.nextDouble();
			produto.setValor(valor);
			System.out.println("Campo alterado com sucesso");
			Util.pausar(2);
			Main.menu();
			break;
		case 4:
			System.out.println("Informe a porcentagem de lucro do produto: ");
			Double porcentagemLucro = Main.ler.nextDouble();
			produto.setPorcentagemLucro(porcentagemLucro);
			System.out.println("Campo alterado com sucesso");
			Util.pausar(2);
			Main.menu();
			break;
		case 5:
			System.out.println("Informe a quantidade em estoque do produto: ");
			int qtdEstoque = Main.ler.nextInt();
			ler.nextLine();
			produto.setQtdEstoque(qtdEstoque);
			System.out.println("Campo alterado com sucesso");
			Util.pausar(2);
			Main.menu();
			break;
		case 6:

		

			System.out.println("Informe o nome do produto: ");
			nome = Main.ler.nextLine();

			System.out.println("Informe a descrição do produto: ");
			 descricao = Main.ler.nextLine();

			System.out.println("Informe o valor do produto");
			 valor = Main.ler.nextDouble();
			 ler.nextLine();

			System.out.println("Informe a porcentagem de lucro do produto");
			 porcentagemLucro = Main.ler.nextDouble();
			 ler.nextLine();

			System.out.println("Informe a quantidade em estoque do produto");
			 qtdEstoque = Main.ler.nextInt();
			 ler.nextLine();
			 produto.setNome(nome);
			 produto.setDescricao(descricao);
			 produto.setPorcentagemLucro(porcentagemLucro);
			 produto.setQtdEstoque(qtdEstoque);
			 produto.setValor(valor);
				System.out.println("Produto alterado com sucesso");
				Util.pausar(2);
			break;

		default:
			System.out.println("Opção inválida");
			Util.pausar(2);
			Main.editarProduto(produto);
			break;
		}

	}

}
