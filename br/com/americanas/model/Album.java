package br.com.americanas.model;

public class Album extends Produto {

	private String genero;
	private String musicoOuBanda;
	private String selo;
	
	public Album() { }

	public Album(String nome, Double preco, String genero, String musicoOuBanda, String selo) {
		super(nome, preco);
		this.genero = genero;
		this.musicoOuBanda = musicoOuBanda;
		this.selo = selo;
	}

	public String getGenero() { return genero; }

	public void setGenero(String genero) { this.genero = genero; }

	public String getMusicoOuBanda() { return musicoOuBanda; }

	public void setMusicoOuBanda(String musicoOuBanda) { this.musicoOuBanda = musicoOuBanda; }

	public String getSelo() { return selo; }

	public void setSelo(String selo) { this.selo = selo; }
}