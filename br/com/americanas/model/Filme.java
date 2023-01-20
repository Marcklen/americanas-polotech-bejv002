package br.com.americanas.model;

public class Filme extends Produto {

	private String genero;
	private String estudio;
	private String diretor;
	private String produtor;

	public Filme() { super(); }
	
	public Filme(String nome, Double preco, String genero, String estudio, String diretor, String produtor) {
		super(nome, preco);
		this.genero = genero;
		this.estudio = estudio;
		this.diretor = diretor;
		this.produtor = produtor;
	}
	
	public String getGenero() { return genero; }
	public void setGenero(String genero) { this.genero = genero; }
	public String getEstudio() { return estudio; }
	public void setEstudio(String estudio) { this.estudio = estudio; }
	public String getDiretor() { return diretor; }
	public void setDiretor(String diretor) {this.diretor = diretor;}
	public String getProdutor() {return produtor; }
	public void setProdutor(String produtor) { this.produtor = produtor; }
}