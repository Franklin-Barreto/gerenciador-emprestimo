package br.com.santander.gerenciadoremprestimo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private BigDecimal patrimonio;
	private LocalDate dataContratacao;
	private BigDecimal salario;
	private String cpf;

	public Cliente(String nome, BigDecimal patrimonio, LocalDate dataContratacao, BigDecimal salario, String cpf) {
		this.nome = nome;
		this.patrimonio = patrimonio;
		this.dataContratacao = dataContratacao;
		this.salario = salario;
		this.cpf = cpf;
	}

	protected Cliente() {
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPatrimonio() {
		return patrimonio;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public String getCpf() {
		return cpf;
	}

	public boolean passouExperiencia() {
		return ChronoUnit.MONTHS.between(LocalDate.now(), dataContratacao) >= 3;
	}

}
