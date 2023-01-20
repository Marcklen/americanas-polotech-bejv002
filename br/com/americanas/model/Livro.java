package br.com.americanas.model;

public class Livro extends Produto {
	private String genero;
	private String editor;
	private String escritor;

	public Livro() { }

	public Livro(String nome, Double preco, String genero, String editor, String escritor) {
		super(nome, preco);
		this.genero = genero;
		this.editor = editor;
		this.escritor = escritor;
	}

	public String getGenero() { return genero; }
	public void setGenero(String genero) { this.genero = genero; }
	public String getEditor() { return editor; }
	public void setEditor(String editor) { this.editor = editor; }
	public String getEscritor() { return escritor; }
	public void setEscritor(String escritor) { this.escritor = escritor; }
}