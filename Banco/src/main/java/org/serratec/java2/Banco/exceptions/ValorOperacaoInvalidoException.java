package org.serratec.java2.Banco.exceptions;

public class ValorOperacaoInvalidoException extends Exception {
	private double valor;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
