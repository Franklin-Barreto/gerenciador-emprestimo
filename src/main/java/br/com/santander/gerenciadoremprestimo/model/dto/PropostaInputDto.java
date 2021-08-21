package br.com.santander.gerenciadoremprestimo.model.dto;

import java.math.BigDecimal;

import br.com.santander.gerenciadoremprestimo.model.Cliente;
import br.com.santander.gerenciadoremprestimo.model.Proposta;

public class PropostaInputDto {

	private Integer clienteId;
	private BigDecimal valor;
	private BigDecimal taxaJuros;
	private int quantidadeParcelas;

	public PropostaInputDto(Integer clienteId, BigDecimal valor, BigDecimal taxaJuros, int quantidadeParcelas) {
		this.clienteId = clienteId;
		this.valor = valor;
		this.taxaJuros = taxaJuros;
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getTaxaJuros() {
		return taxaJuros;
	}

	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public Proposta converte(Cliente cliente) {
		return new Proposta(valor, taxaJuros, quantidadeParcelas, cliente);
	}

}
