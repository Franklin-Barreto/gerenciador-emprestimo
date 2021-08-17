package br.com.santander.gerenciadoremprestimo.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dataSolicitacao;
	private BigDecimal valor;
	private BigDecimal taxaJuros;
	private BigInteger quantidadeParcelas;
	@ManyToOne
	private Cliente cliente;

	public Proposta(BigDecimal valor, BigDecimal taxaJuros, int quantidadeParcelas, Cliente cliente) {
		this.dataSolicitacao = LocalDate.now();
		this.valor = valor;
		this.taxaJuros = taxaJuros.divide(BigDecimal.valueOf(100));
		this.cliente = cliente;
		this.quantidadeParcelas = BigInteger.valueOf(quantidadeParcelas);
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getTaxaJuros() {
		return taxaJuros;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public BigDecimal getMontante() {
		return taxaJuros.add(BigDecimal.ONE).pow(quantidadeParcelas.intValue()).multiply(valor).setScale(2,
				RoundingMode.HALF_UP);
	}

}
