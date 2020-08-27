package org.serratec.java2.Banco.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.java2.Banco.dominio.Conta;
import org.serratec.java2.Banco.dominio.Operacao;
import org.serratec.java2.Banco.dominio.Tipo;
import org.serratec.java2.Banco.exceptions.ContaInvalidaException;
import org.serratec.java2.Banco.exceptions.ContaNotFoundException;
import org.serratec.java2.Banco.exceptions.SaldoInsuficienteException;
import org.springframework.stereotype.Service;

@Service
public class BancoService {

	private List<Conta> contas;
	private int proximaConta = 0;

	public BancoService() {
		contas = new ArrayList<Conta>();
		contas.add(new Conta(1, "Nathalia Carvalho", 3000));
		contas.add(new Conta(2, "Estefany Christina", 4000));
		contas.add(new Conta(3, "Sandra Carvalho", 5000));
		contas.add(new Conta(4, "Bruno Gonçalves", 6000));
		contas.add(new Conta(5, "Nei Damazio", 7000));
		contas.add(new Conta(6, "Lucca Nunes", 8000));
		proximaConta = 7;

	}

	public List<Conta> listarContas() {
		return contas;

	}

	public Conta recuperarPorNumero(Integer numero) throws ContaNotFoundException, ContaInvalidaException {

		validarNumero(numero);

		boolean encontrada = false;
		Conta contaEncontrada = null;
		for (Conta conta : contas) {
			if (conta.getNumero() == numero) {
				encontrada = true;
				contaEncontrada = conta;
				break;
			}
		}

		if (!encontrada)
			throw new ContaNotFoundException(numero);

		return contaEncontrada;

	}

	public Conta incluir(Conta novaConta) {
		novaConta.setNumero(proximaConta);
		contas.add(novaConta);
		proximaConta++;
		return novaConta;
	}

	public Conta atualizarPorNumero(Conta conta) throws ContaNotFoundException, ContaInvalidaException {
		Conta contaEncontrada = recuperarPorNumero(conta.getNumero());
		if (contaEncontrada == null) {
			return null;
		}

		if (!"".equals(conta.getTitular()))
			contaEncontrada.setTitular(conta.getTitular());

		return contaEncontrada;
	}

	public void apagarPorNumero(Integer numero) throws ContaNotFoundException, ContaInvalidaException {
		Conta conta = recuperarPorNumero(numero);
		contas.remove(conta);
	}

	private void validarNumero(Integer numero) throws ContaInvalidaException {
		if (numero == null || numero <= 0)
			throw new ContaInvalidaException(numero);

	}

	public Operacao operacaoDebito(Integer numero, Tipo tipo, double valor)
			throws SaldoInsuficienteException, ContaNotFoundException, ContaInvalidaException {
		Conta conta = recuperarPorNumero(numero);
		Operacao operacao = new Operacao();
		operacao.setConta(conta);
		operacao.setValor(valor);
		operacao.setTipo(tipo);

		if (operacao.getTipo() == tipo.DEBITO) {
			//FIXME Aqui deveriam ser 2 exceptions diferentes: SaldoInsuficienteException e ValorOperacaoInvalidoException
			//TODO O valor mínimo poderia ser configurado em application.properties
			if (operacao.getValor() > conta.getSaldo() || operacao.getValor() < 50) {
				throw new SaldoInsuficienteException();
			} else {
				conta.setSaldo(conta.getSaldo() - operacao.getValor());
			}
		}
		return operacao;
	}
	
	public Operacao operacaoCredito(Integer numero, Tipo tipo, double valor)
			throws ContaNotFoundException, ContaInvalidaException {
		Conta conta = recuperarPorNumero(numero);
		Operacao operacao = new Operacao();
		operacao.setConta(conta);
		operacao.setValor(valor);
		operacao.setTipo(tipo);
	
		 if (operacao.getTipo() == tipo.CREDITO){
			conta.setSaldo(conta.getSaldo() + operacao.getValor());
		}
		return operacao;
	}

}
