package br.com.americanas.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.americanas.model.Brinquedo;

public class BrinquedoController {

	static BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Brinquedo> brinquedos;

	public BrinquedoController() {
		brinquedos = new ArrayList<>();
	}

	public void cadastrarBrinquedo() throws IOException {
		System.out.println("CADASTRO DE BRINQUEDO");
		System.out.println("Informe o nome do Brinquedo?");
		String nome = ler.readLine();
		System.out.println("Informe o tipo de Brinquedo? " + nome);
		String tipo = ler.readLine();
		System.out.println("Informe o valor de Brinquedo ?");
		Double preco = Double.parseDouble(ler.readLine());
		brinquedos.add(new Brinquedo(nome, preco, tipo));
		System.out.println("\nBrinquedo " + nome + " cadastrado com sucesso!");
	}

	public void buscarBrinquedos() {
		if (brinquedos.size() == 0) {
			System.out.println("Lista de Brinquedos Vazia!");
		} else {
			System.out.println("Listando Brinquedos...");
			for (Brinquedo b : brinquedos) {
				System.out.println("ID:      " + b.getId() + "\nNOME:    " + b.getNome() 
						+ "\nVALOR: R$" + b.getPreco()
						+ "\n--------------------------------");
			}
		}
	}

	public void buscarBrinquedosPorNome() {
		System.out.println("Informe o NOME do Brinquedo ?");
		String nome = scanner.nextLine();
		for (int i = 0; i < brinquedos.size(); i++) {
			if (brinquedos.get(i).getNome().equalsIgnoreCase(nome)) {
				System.out.println("ID:      " + brinquedos.get(i).getId() + "\nNOME:    " 
						+ brinquedos.get(i).getNome()
						+ "\nVALOR: R$" + brinquedos.get(i).getPreco() + "\n--------------------------------");
			}
		}
	}

	public void atualizarBrinquedosPorNome() {
		System.out.println("Informe o NOME do Brinquedo ?");
		String nome = scanner.nextLine();
		for (Brinquedo brinquedo : brinquedos) {
			if (brinquedo.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Informe o NOVO NOME do Brinquedo ?");
				nome = scanner.nextLine();
				brinquedo.setNome(nome);
				System.out.println("Brinquedo " + nome + " ATUALIZADO som sucesso!!!");
			}
		}
	}

	public void deletarBrinquedosPorNome() {
		System.out.println("Informe o NOME do Brinquedo ?");
		String nome = scanner.nextLine();
		for (Brinquedo brinquedo : brinquedos) {
			if (brinquedo.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Brinquedo "+ nome + " REMOVIDO som sucesso!!!");
				brinquedos.remove(brinquedo);
			} 
		}
	}
	
	public void venderBrinquedo() {
		System.out.println("Informe o NOME do Brinquedo que deseja COMPRAR ?");
		String nome = scanner.nextLine();
		for (Brinquedo brinquedo : brinquedos) {
			if (brinquedo.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Venda REALIZADA com sucesso!");
				Caixa.valorEmCaixa += brinquedo.getPreco();
				brinquedos.remove(brinquedo);
				break;
			}
		}
		System.out.println("O Valor em caixa atual é de R$ " + Caixa.getValorEmCaixa());
	}
}