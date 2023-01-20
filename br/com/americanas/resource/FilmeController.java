package br.com.americanas.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.americanas.model.Filme;

public class FilmeController {

	static BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
	static Scanner scanner = new Scanner(System.in);
	static List<Filme> filmes = new ArrayList<>();
	
	public void cadastrarFilme() throws IOException {
		System.out.println("CADASTRO DE FILME");
		System.out.println("Informe o nome do Filme?");
		String nome = ler.readLine();
		System.out.println("Informe o genero do Filme? " + nome);
		String genero = ler.readLine();
		System.out.println("Informe o estudio do Filme? " + nome);
		String estudio = ler.readLine();
		System.out.println("Informe o diretor do Filme? " + nome);
		String diretor= ler.readLine();
		System.out.println("Informe o produtor do Filme? " + nome);
		String produtor = ler.readLine();
		System.out.println("Informe o valor de Filme? ");
		Double preco = Double.parseDouble(ler.readLine());
		filmes.add(new Filme(nome, preco, genero, estudio, diretor, produtor));
		System.out.println("\nAlbum " + nome + " cadastrado com sucesso!");
	}

	public void buscarFilmes() {
		if (filmes.size() == 0) {
			System.out.println("Lista de Filmes Vazia!");
		} else {
			System.out.println("Listando Filmes...");
			for (Filme f : filmes) {
				System.out.println("ID:      " + f.getId() + "\nNOME:    " + f.getNome() 
						+ "\nVALOR: R$" + f.getPreco()
						+ "\n--------------------------------");
			}
		}
	}

	public void buscarFilmePorNome() {
		System.out.println("Informe o NOME do Filme ?");
		String nome = scanner.nextLine();
		for (int i = 0; i < filmes.size(); i++) {
			if (filmes.get(i).getNome().equalsIgnoreCase(nome)) {
				System.out.println("ID:      " + filmes.get(i).getId() + "\nNOME:    " 
						+ filmes.get(i).getNome()
						+ "\nVALOR: R$" + filmes.get(i).getPreco() + "\n--------------------------------");
			}
		}
	}

	public void atualizarFilmePorNome() {
		System.out.println("Informe o NOME do Filme ?");
		String nome = scanner.nextLine();
		for (Filme f : filmes) {
			if (f.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Informe o NOVO NOME do Filme ?");
				nome = scanner.nextLine();
				f.setNome(nome);
				System.out.println("Filme " + nome + " ATUALIZADO som sucesso!!!");
			}
		}
	}

	public void deletarFilmePorNome() {
		System.out.println("Informe o NOME do Filme ?");
		String nome = scanner.nextLine();
		for (Filme f : filmes) {
			if (f.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Filme "+ nome + " REMOVIDO som sucesso!!!");
				filmes.remove(f);
			} 
		}
	}
	
	public void venderFilme() {
		System.out.println("Informe o NOME do Filme que deseja COMPRAR ?");
		String nome = scanner.nextLine();
		for (Filme f : filmes) {
			if (f.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Venda REALIZADA com sucesso!");
				Caixa.valorEmCaixa += f.getPreco();
				filmes.remove(f);
				break;
			}
		}
		System.out.println("O Valor em caixa atual é de R$ " + Caixa.getValorEmCaixa());
	}
}
