package br.com.americanas.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.americanas.model.Jogo;

public class JogoController {

	static BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
	static Scanner scanner = new Scanner(System.in);
	static List<Jogo> jogos = new ArrayList<>();
	
	public void cadastrarJogo() throws IOException {
		System.out.println("CADASTRO DE FILME");
		System.out.println("Informe o nome do Jogo?");
		String nome = ler.readLine();
		System.out.println("Informe o genero do Jogo? " + nome);
		String genero = ler.readLine();
		System.out.println("Informe o estudio do Jogo? " + nome);
		String estudio = ler.readLine();
		System.out.println("Informe o distribuidor do Jogo? " + nome);
		String distribuidor= ler.readLine();
		System.out.println("Informe o valor do Jogo? ");
		Double preco = Double.parseDouble(ler.readLine());
		jogos.add(new Jogo(nome, preco, genero, distribuidor, estudio));
		System.out.println("\nJogo " + nome + " cadastrado com sucesso!");
	}

	public void buscarJogos() {
		if (jogos.size() == 0) {
			System.out.println("Lista de Jogos Vazia!");
		} else {
			System.out.println("Listando Jogos...");
			for (Jogo j : jogos) {
				System.out.println("ID:      " + j.getId() + "\nNOME:    " + j.getNome() 
						+ "\nVALOR: R$" + j.getPreco()
						+ "\n--------------------------------");
			}
		}
	}

	public void buscarJogoPorNome() {
		System.out.println("Informe o NOME do Jogo ?");
		String nome = scanner.nextLine();
		for (int i = 0; i < jogos.size(); i++) {
			if (jogos.get(i).getNome().equalsIgnoreCase(nome)) {
				System.out.println("ID:      " + jogos.get(i).getId() + "\nNOME:    " 
						+ jogos.get(i).getNome()
						+ "\nVALOR: R$" + jogos.get(i).getPreco() + "\n--------------------------------");
			}
		}
	}

	public void atualizarJogoPorNome() {
		System.out.println("Informe o NOME do Jogo ?");
		String nome = scanner.nextLine();
		for (Jogo j : jogos) {
			if (j.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Informe o NOVO NOME do Jogo ?");
				nome = scanner.nextLine();
				j.setNome(nome);
				System.out.println("Jogo " + nome + " ATUALIZADO som sucesso!!!");
			}
		}
	}

	public void deletarJogoPorNome() {
		System.out.println("Informe o NOME do Jogo ?");
		String nome = scanner.nextLine();
		for (Jogo j : jogos) {
			if (j.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Jogo "+ nome + " REMOVIDO som sucesso!!!");
				jogos.remove(j);
			} 
		}
	}
	
	public void venderJogo() {
		System.out.println("Informe o NOME do Jogo que deseja COMPRAR ?");
		String nome = scanner.nextLine();
		for (Jogo j : jogos) {
			if (j.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Venda REALIZADA com sucesso!");
				Caixa.valorEmCaixa += j.getPreco();
				jogos.remove(j);
				break;
			}
		}
		System.out.println("O Valor em caixa atual é de R$ " + Caixa.getValorEmCaixa());
	}
}

