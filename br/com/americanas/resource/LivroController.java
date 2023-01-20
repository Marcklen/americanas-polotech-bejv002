package br.com.americanas.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.americanas.model.Livro;

public class LivroController {

	static BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
	static Scanner scanner = new Scanner(System.in);
	static List<Livro> livros = new ArrayList<>();
	
	public void cadastrarLivro() throws IOException {
		System.out.println("CADASTRO DE FILME");
		System.out.println("Informe o nome do Livro?");
		String nome = ler.readLine();
		System.out.println("Informe o genero do Livro? " + nome);
		String genero = ler.readLine();
		System.out.println("Informe o escritor do Livro? " + nome);
		String escritor = ler.readLine();
		System.out.println("Informe o editor do Livro? " + nome);
		String editor = ler.readLine();
		System.out.println("Informe o valor do Livro? ");
		Double preco = Double.parseDouble(ler.readLine());
		livros.add(new Livro(nome, preco, genero, escritor, editor));
		System.out.println("\nLivro " + nome + " cadastrado com sucesso!");
	}

	public void buscarLivros() {
		if (livros.size() == 0) {
			System.out.println("Lista de Livros Vazia!");
		} else {
			System.out.println("Listando Livros...");
			for (Livro l : livros) {
				System.out.println("ID:      " + l.getId() + "\nNOME:    " + l.getNome() 
						+ "\nVALOR: R$" + l.getPreco()
						+ "\n--------------------------------");
			}
		}
	}

	public void buscarLivroPorNome() {
		System.out.println("Informe o NOME do Livro ?");
		String nome = scanner.nextLine();
		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getNome().equalsIgnoreCase(nome)) {
				System.out.println("ID:      " + livros.get(i).getId() + "\nNOME:    " 
						+ livros.get(i).getNome()
						+ "\nVALOR: R$" + livros.get(i).getPreco() + "\n--------------------------------");
			}
		}
	}

	public void atualizarLivroPorNome() {
		System.out.println("Informe o NOME do Livro ?");
		String nome = scanner.nextLine();
		for (Livro l : livros) {
			if (l.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Informe o NOVO NOME do Livro ?");
				nome = scanner.nextLine();
				l.setNome(nome);
				System.out.println("Filme " + nome + " ATUALIZADO som sucesso!!!");
			}
		}
	}

	public void deletarLivroPorNome() {
		System.out.println("Informe o NOME do Livro ?");
		String nome = scanner.nextLine();
		for (Livro l : livros) {
			if (l.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Livro "+ nome + " REMOVIDO som sucesso!!!");
				livros.remove(l);
			} 
		}
	}
	
	public void venderLivro() {
		System.out.println("Informe o NOME do Livro que deseja COMPRAR ?");
		String nome = scanner.nextLine();
		for (Livro l : livros) {
			if (l.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Venda REALIZADA com sucesso!");
				Caixa.valorEmCaixa += l.getPreco();
				livros.remove(l);
				break;
			}
		}
		System.out.println("O Valor em caixa atual é de R$ " + Caixa.getValorEmCaixa());
	}
}