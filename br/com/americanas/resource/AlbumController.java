package br.com.americanas.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.americanas.model.Album;

public class AlbumController {
	static BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Album> albuns;

	public AlbumController() {
		albuns = new ArrayList<>();
	}

	public void cadastrarAlbum() throws IOException {
		System.out.println("CADASTRO DE ALBUM MUSICAL");
		System.out.println("Informe o nome do Album?");
		String nome = ler.readLine();
		System.out.println("Informe o nome do Musico ou Banda? " + nome);
		String musicoOuBanda = ler.readLine();
		System.out.println("Informe o genero do Album? " + nome);
		String genero = ler.readLine();
		System.out.println("Informe o selo do Album? " + nome);
		String selo= ler.readLine();
		System.out.println("Informe o valor de Album ?");
		Double preco = Double.parseDouble(ler.readLine());
		albuns.add(new Album(nome, preco, genero, musicoOuBanda, selo));
		System.out.println("\nAlbum " + nome + " cadastrado com sucesso!");
	}

	public void buscarAlbuns() {
		if (albuns.size() == 0) {
			System.out.println("Lista de Albuns Vazia!");
		} else {
			System.out.println("Listando Albuns...");
			for (Album a : albuns) {
				System.out.println("ID:      " + a.getId() + "\nNOME:    " + a.getNome() 
						+ "\nVALOR: R$" + a.getPreco()
						+ "\n--------------------------------");
			}
		}
	}

	public void buscarAlbumPorNome() {
		System.out.println("Informe o NOME do Album ?");
		String nome = scanner.nextLine();
		for (int i = 0; i < albuns.size(); i++) {
			if (albuns.get(i).getNome().equalsIgnoreCase(nome)) {
				System.out.println("ID:      " + albuns.get(i).getId() + "\nNOME:    " 
						+ albuns.get(i).getNome()
						+ "\nVALOR: R$" + albuns.get(i).getPreco() + "\n--------------------------------");
			}
		}
	}

	public void atualizarAlbumPorNome() {
		System.out.println("Informe o NOME do Album ?");
		String nome = scanner.nextLine();
		for (Album a : albuns) {
			if (a.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Informe o NOVO NOME do Album ?");
				nome = scanner.nextLine();
				a.setNome(nome);
				System.out.println("Album " + nome + " ATUALIZADO som sucesso!!!");
			}
		}
	}

	public void deletarAlbumPorNome() {
		System.out.println("Informe o NOME do Album ?");
		String nome = scanner.nextLine();
		for (Album a : albuns) {
			if (a.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Album "+ nome + " REMOVIDO som sucesso!!!");
				albuns.remove(a);
			} 
		}
	}
	
	public void venderAlbum() {
		System.out.println("Informe o NOME do Album que deseja COMPRAR ?");
		String nome = scanner.nextLine();
		for (Album a : albuns) {
			if (a.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Venda REALIZADA com sucesso!");
				Caixa.valorEmCaixa += a.getPreco();
				albuns.remove(a);
				break;
			}
		}
		System.out.println("O Valor em caixa atual é de R$ " + Caixa.getValorEmCaixa());
	}
}