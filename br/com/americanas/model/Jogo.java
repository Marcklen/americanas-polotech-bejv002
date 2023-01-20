package br.com.americanas.model;

public class Jogo extends Produto {
	
	private String genero;
	private String distribuidor;
	private String estudio;

	public Jogo() { }

	public Jogo(String nome, Double preco, String genero, String distribuidor, String estudio) {
		super(nome, preco);
		this.genero = genero;
		this.distribuidor = distribuidor;
		this.estudio = estudio;
	}

	public String getGenero() { return genero; }
	public void setGenero(String genero) { this.genero = genero; }
	public String getDistribuidor() { return distribuidor; }
	public void setDistribuidor(String distribuidor) { this.distribuidor = distribuidor; }
	public String getEstudio() { return estudio; }
	public void setEstudio(String estudio) { this.estudio = estudio; }
}