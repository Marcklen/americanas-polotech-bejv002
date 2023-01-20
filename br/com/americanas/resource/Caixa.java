package br.com.americanas.resource;

public class Caixa {

	public static Double valorEmCaixa = 20d;
	
	public Caixa() {}
	
	public Caixa(Double novoValor) {  Caixa.valorEmCaixa = novoValor; }
	
	public static Double getValorEmCaixa() { return valorEmCaixa; }
	
	public void setValorEmCaixa(Double valorEmCaixa) { Caixa.valorEmCaixa = valorEmCaixa; }
}