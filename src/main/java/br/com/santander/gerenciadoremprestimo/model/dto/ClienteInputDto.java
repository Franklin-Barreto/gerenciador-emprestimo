package br.com.santander.gerenciadoremprestimo.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.santander.gerenciadoremprestimo.model.Cliente;

public class ClienteInputDto {

	private String nome;
	private BigDecimal patrimonio;
	private LocalDate dataContratacao;
	private BigDecimal salario;
	private String cpf;

	public ClienteInputDto(String nome, BigDecimal patrimonio, LocalDate dataContratacao, BigDecimal salario,
			String cpf) {
		this.nome = nome;
		this.patrimonio = patrimonio;
		this.dataContratacao = dataContratacao;
		this.salario = salario;
		this.cpf = cpf;
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
	
	public Cliente converte() {
		return new Cliente(nome, patrimonio, dataContratacao, salario, cpf);
	}

}
