package br.com.americanas.model;

public class Brinquedo extends Produto {

	private String tipo;
	
	public Brinquedo() {}
	
	public Brinquedo(String nome, Double preco, String tipo) {
		super(nome, preco);
		this.tipo = tipo;
	}

	public String getTipo() { return tipo; }
	
	public void setTipo(String tipo) { this.tipo = tipo; }
}