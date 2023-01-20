package br.com.americanas.model;

public class Produto {

	private Integer id;
	private String nome;
	private Double preco;
    private static int contadorId = 1;
	
	public Produto() {}
	
	public Produto(String nome, Double preco) {
		id = contadorId++;
		this.nome = nome;
		this.preco = preco;
	}
	
	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getNome() { return nome; }

	public void setNome(String nome) { this.nome = nome; }

	public Double getPreco() { return preco; }

	public void setPreco(Double preco) { this.preco = preco; }
}