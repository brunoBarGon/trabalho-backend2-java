package org.serratec.java2.Banco.exceptions;

public class SaldoInsuficienteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5764254214604792692L;
	
	private double valor;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
