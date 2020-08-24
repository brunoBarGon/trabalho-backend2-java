package org.serratec.java2.Banco.exceptions;

public class ContaNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8734425750800849360L;
	
	private Integer numero;

	public ContaNotFoundException(Integer numero) {
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
