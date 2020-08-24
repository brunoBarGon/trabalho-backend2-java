package org.serratec.java2.Banco.dominio;

public class Operacao {
 	private Tipo tipo;
	private double valor;
	private Conta conta;
	
	public Operacao() {
		super();
	}

	public Operacao(Tipo tipo, double valor, Conta conta) {
		super();
		this.tipo = tipo;
		this.valor = valor;
		this.conta = conta;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	

}