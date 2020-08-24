package org.serratec.java2.Banco.exceptions;

public class ContaInvalidaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5377412370400550037L;

	private Integer numero;

	public ContaInvalidaException(Integer numero) {
		super();
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
