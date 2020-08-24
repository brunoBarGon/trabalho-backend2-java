package org.serratec.java2.Banco.controllers;

import org.serratec.java2.Banco.exceptions.ContaInvalidaException;
import org.serratec.java2.Banco.exceptions.ContaNotFoundException;
import org.serratec.java2.Banco.exceptions.SaldoInsuficienteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class BancoExceptionController {
	
	@ExceptionHandler(ContaNotFoundException.class)
	public ResponseEntity<String> trataTodoNotFound(ContaNotFoundException exception) {
		String msg = String.format("A conta de número %d não foi encontrada.", exception.getNumero());
		return ResponseEntity.notFound()
				.header("x-erro-msg", msg)
				.header("s-erro-code", "CONTA_NOT_FOUND")
				.header("x-erro-value", exception.getNumero().toString())
				.build();
	}

	@ExceptionHandler(ContaInvalidaException.class)
	public ResponseEntity<String> trataTodoIdInvalido(ContaInvalidaException exception) {
		String msg = String.format("O número %d é inválido. Favor informar uma conta de número maior que 0(zero)",
				exception.getNumero());
		return ResponseEntity.badRequest()
				.header("x-erro-msg", msg)
				.header("s-erro-code", "CONTA_NUMERO_INVALIDO")
				.header("x-erro-value", exception.getNumero().toString())
				.build();
	}

	@ExceptionHandler(SaldoInsuficienteException.class)
	public ResponseEntity<String> trataSaldoException(SaldoInsuficienteException exception){
		String msg = String.format("Operação não realizada. Saldo insuficiente ou valor de saque foi menor do que 50", exception.getValor());
		return ResponseEntity.badRequest()
				.header("x-erro-msg", msg)
				.header("s-erro-code", "SALDO_INVALIDO")
				.build();
	}
	
}
