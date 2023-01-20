package br.com.americanas;

import java.io.IOException;
import java.util.Scanner;

import br.com.americanas.resource.AlbumController;
import br.com.americanas.resource.BrinquedoController;
import br.com.americanas.resource.Caixa;
import br.com.americanas.resource.FilmeController;
import br.com.americanas.resource.JogoController;
import br.com.americanas.resource.LivroController;

public class LivrariaApp {

	static Scanner scanner = new Scanner(System.in);
	// importante controladores para manipulação da livraria
	static BrinquedoController controllerBrinquedo = new BrinquedoController();
	static AlbumController controllerAlbum = new AlbumController();
	static FilmeController controllerFilme = new FilmeController();
	static JogoController controllerJogo = new JogoController();
	static LivroController controllerLivro = new LivroController();

	public static void main(String[] args) throws IOException {
		int op;
		do {
			inicializacao();
			op = scanner.nextInt();
			switch (op) {
			case 1: {
				menuAdminProdutos();
				break;
			}
			case 2:
				menuAdminVendas();
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.printf("Valor em Caixa ------ R$ %.2f%n",  Caixa.getValorEmCaixa());
				System.out.println("---------------------------------");
				break;
			case 0: {
				System.out.println("Até a próxima!");
				break;
			}
			default:
				throw new IllegalArgumentException("Opção digitada está errada : " + op);
			}
		} while (op != 0);
	}

	private static void inicializacao() throws IOException {
		System.out.println("\t\t+-+-------- MENU PRINCIPAL -------+");
		System.out.println("\t\t|1|-  Gerenciamento de Produtos   |");
		System.out.println("\t\t|2|-  Gerenciamento de Pedidos    |");
		System.out.println("\t\t|3|-  Verificar Saldo em Caixa    |");
		System.out.println("\t\t|0|-  Sair do Sistema             |");
		System.out.println("\t\t+---------------------------------+");
		System.out.print("Digite a opção desejada: ");
	}

	private static void menuAdminProdutos() throws IOException {
		int escolha;
		do {
			System.out.println("\t\t+-+---- GERENCIAMENTO DE PRODUTOS ----+");
			System.out.println("\t\t|1|-  Albuns Musicais                 |");
			System.out.println("\t\t|2|-  Brinquedos                      |");
			System.out.println("\t\t|3|-  Filmes                          |");
			System.out.println("\t\t|4|-  Jogos                           |");
			System.out.println("\t\t|5|-  Livros                          |");
			System.out.println("\t\t|0|-  Retornar ao Menu Principal      |");
			System.out.println("\t\t+-------------------------------------+");
			System.out.print("Digite a opção desejada: ");
			escolha = scanner.nextInt();

			switch (escolha) {
			case 1: menuGerenciamentoAlbuns(); break;
			case 2: menuGerenciamentoBrinquedos(); break;
			case 3: menuGerenciamentoFilmes(); break;
			case 4: menuGerenciamentoJogos(); break;
			case 5: menuGerenciamentoLivros(); break;
			case 0: System.out.println("Voltando ao menu inicial\n"); break;
			default: throw new IllegalArgumentException("Opção digitada está errada : " + escolha);
			}
		} while (escolha != 0);
	}

	private static void menuAdminVendas() throws IOException {
		int escolha;
		do {
			System.out.println("\t\t+-+----- GERENCIAMENTO DE VENDAS -----+");
			System.out.println("\t\t|1|-  Comprar Albuns Musicais         |");
			System.out.println("\t\t|2|-  Comprar Brinquedos              |");
			System.out.println("\t\t|3|-  Comprar Filmes                  |");
			System.out.println("\t\t|4|-  Comprar Jogos                   |");
			System.out.println("\t\t|5|-  Comprar Livros                  |");
			System.out.println("\t\t|0|-  Retornar ao Menu Principal      |");
			System.out.println("\t\t+-------------------------------------+");
			System.out.print("Digite a opção desejada: ");
			escolha = scanner.nextInt();

			switch (escolha) {
			case 1: controllerAlbum.venderAlbum(); break;
			case 2: controllerBrinquedo.venderBrinquedo(); break;
			case 3: controllerFilme.venderFilme(); break;
			case 4: controllerJogo.venderJogo(); break;
			case 5: controllerLivro.venderLivro(); break;
			case 0: System.out.println("Voltando ao menu inicial\n"); break;
			default: throw new IllegalArgumentException("Opção digitada está errada : " + escolha);
			}
		} while (escolha != 0);
	}
	
	private static void menuGerenciamentoAlbuns() throws IOException {
		int escolha;
		do {
			System.out.println("\t\t+-+----- GERENCIAMENTO DE ALBUNS -----+");
			System.out.println("\t\t|1|-  Cadastrar                       |");
			System.out.println("\t\t|2|-  Buscar Todos                    |");
			System.out.println("\t\t|3|-  Buscar por Nome                 |");
			System.out.println("\t\t|4|-  Atualizar por Nome              |");
			System.out.println("\t\t|5|-  Excluir por Nome                |");
			System.out.println("\t\t|0|-  Retornar ao Menu Anterior       |");
			System.out.println("\t\t+-------------------------------------+");
			System.out.print("Digite a opção desejada: ");
			escolha = scanner.nextInt();
			switch (escolha) {
			case 1: controllerAlbum.cadastrarAlbum(); break;
			case 2: controllerAlbum.buscarAlbuns(); break;
			case 3: controllerAlbum.buscarAlbumPorNome(); break;
			case 4: controllerAlbum.atualizarAlbumPorNome(); break;
			case 5: controllerAlbum.deletarAlbumPorNome(); break;
			case 0: System.out.println("Voltando ao menu inicial\n"); break;
			default: throw new IllegalArgumentException("Opção digitada está errada : " + escolha);
			}
		} while (escolha != 0);
	}
	
	private static void menuGerenciamentoBrinquedos() throws IOException {
		int escolha;
		do {
			System.out.println("\t\t+-+--- GERENCIAMENTO DE BRINQUEDOS ---+");
			System.out.println("\t\t|1|-  Cadastrar                       |");
			System.out.println("\t\t|2|-  Buscar Todos                    |");
			System.out.println("\t\t|3|-  Buscar por Nome                 |");
			System.out.println("\t\t|4|-  Atualizar por Nome              |");
			System.out.println("\t\t|5|-  Excluir por Nome                |");
			System.out.println("\t\t|0|-  Retornar ao Menu Anterior       |");
			System.out.println("\t\t+-------------------------------------+");
			System.out.print("Digite a opção desejada: ");
			escolha = scanner.nextInt();
			switch (escolha) {
			case 1: controllerBrinquedo.cadastrarBrinquedo(); break;
			case 2: controllerBrinquedo.buscarBrinquedos(); break;
			case 3: controllerBrinquedo.buscarBrinquedosPorNome(); break;
			case 4: controllerBrinquedo.atualizarBrinquedosPorNome(); break;
			case 5: controllerBrinquedo.deletarBrinquedosPorNome(); break;
			case 0: System.out.println("Voltando ao menu inicial\n"); break;
			default: throw new IllegalArgumentException("Opção digitada está errada : " + escolha);
			}
		} while (escolha != 0);
	}

	private static void menuGerenciamentoFilmes() throws IOException {
		int escolha;
		do {
			System.out.println("\t\t+-+----- GERENCIAMENTO DE FILMES -----+");
			System.out.println("\t\t|1|-  Cadastrar                       |");
			System.out.println("\t\t|2|-  Buscar Todos                    |");
			System.out.println("\t\t|3|-  Buscar por Nome                 |");
			System.out.println("\t\t|4|-  Atualizar por Nome              |");
			System.out.println("\t\t|5|-  Excluir por Nome                |");
			System.out.println("\t\t|0|-  Retornar ao Menu Anterior       |");
			System.out.println("\t\t+-------------------------------------+");
			System.out.print("Digite a opção desejada: ");
			escolha = scanner.nextInt();
			switch (escolha) {
			case 1: controllerFilme.cadastrarFilme(); break;
			case 2: controllerFilme.buscarFilmes(); break;
			case 3: controllerFilme.buscarFilmePorNome(); break;
			case 4: controllerFilme.atualizarFilmePorNome(); break;
			case 5: controllerFilme.deletarFilmePorNome(); break;
			case 0: System.out.println("Voltando ao menu inicial\n"); break;
			default: throw new IllegalArgumentException("Opção digitada está errada : " + escolha);
			}
		} while (escolha != 0);
	}
	
	private static void menuGerenciamentoJogos() throws IOException {
		int escolha;
		do {
			System.out.println("\t\t+-+------ GERENCIAMENTO DE JOGOS -----+");
			System.out.println("\t\t|1|-  Cadastrar                       |");
			System.out.println("\t\t|2|-  Buscar Todos                    |");
			System.out.println("\t\t|3|-  Buscar por Nome                 |");
			System.out.println("\t\t|4|-  Atualizar por Nome              |");
			System.out.println("\t\t|5|-  Excluir por Nome                |");
			System.out.println("\t\t|0|-  Retornar ao Menu Anterior       |");
			System.out.println("\t\t+-------------------------------------+");
			System.out.print("Digite a opção desejada: ");
			escolha = scanner.nextInt();
			switch (escolha) {
			case 1: controllerJogo.cadastrarJogo(); break;
			case 2: controllerJogo.buscarJogos(); break;
			case 3: controllerJogo.buscarJogoPorNome(); break;
			case 4: controllerJogo.atualizarJogoPorNome(); break;
			case 5: controllerJogo.deletarJogoPorNome(); break;
			case 0: System.out.println("Voltando ao menu inicial\n"); break;
			default: throw new IllegalArgumentException("Opção digitada está errada : " + escolha);
			}
		} while (escolha != 0);
	}

	private static void menuGerenciamentoLivros() throws IOException {
		int escolha;
		do {
			System.out.println("\t\t+-+----- GERENCIAMENTO DE LIVROS -----+");
			System.out.println("\t\t|1|-  Cadastrar                       |");
			System.out.println("\t\t|2|-  Buscar Todos                    |");
			System.out.println("\t\t|3|-  Buscar por Nome                 |");
			System.out.println("\t\t|4|-  Atualizar por Nome              |");
			System.out.println("\t\t|5|-  Excluir por Nome                |");
			System.out.println("\t\t|0|-  Retornar ao Menu Anterior       |");
			System.out.println("\t\t+-------------------------------------+");
			System.out.print("Digite a opção desejada: ");
			escolha = scanner.nextInt();
			switch (escolha) {
			case 1: controllerLivro.cadastrarLivro(); break;
			case 2: controllerLivro.buscarLivros(); break;
			case 3: controllerLivro.buscarLivroPorNome(); break;
			case 4: controllerLivro.atualizarLivroPorNome(); break;
			case 5: controllerLivro.deletarLivroPorNome(); break;
			case 0: System.out.println("Voltando ao menu inicial\n"); break;
			default: throw new IllegalArgumentException("Opção digitada está errada : " + escolha);
			}
		} while (escolha != 0);
	}
}