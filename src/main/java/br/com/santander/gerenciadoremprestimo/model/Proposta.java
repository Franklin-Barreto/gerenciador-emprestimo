package br.com.santander.gerenciadoremprestimo.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dataSolicitacao;
	private BigDecimal valor;
	private BigDecimal taxaJuros;
	private BigDecimal quantidadeParcelas;
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToOne
	private Cliente cliente;
	@JsonManagedReference
	@OneToMany(mappedBy = "proposta",cascade = CascadeType.ALL)
	private List<Parcela> parcelas = new ArrayList<>();

	public Proposta(BigDecimal valor, BigDecimal taxaJuros, int quantidadeParcelas, Cliente cliente) {
		this.dataSolicitacao = LocalDate.now();
		this.valor = valor;
		this.taxaJuros = taxaJuros.divide(BigDecimal.valueOf(100));
		this.cliente = cliente;
		this.quantidadeParcelas = BigDecimal.valueOf(quantidadeParcelas);
		this.status = Status.PENDENTE;
		gerarParcelas();
	}
	
	protected Proposta() {}

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

	public BigDecimal getJuros() {
		return taxaJuros.add(BigDecimal.ONE).pow(quantidadeParcelas.intValue()).subtract(BigDecimal.ONE).multiply(valor)
				.setScale(2, RoundingMode.HALF_UP);

	}

	public BigDecimal getMontante() {
		return taxaJuros.add(BigDecimal.ONE).pow(quantidadeParcelas.intValue()).multiply(valor).setScale(2,
				RoundingMode.HALF_UP);
	}

	public void gerarParcelas() {
		LocalDate dataVencimento = dataSolicitacao;
		List<Parcela> parcelas = new ArrayList<>();
		BigDecimal valor = getJuros().divide(quantidadeParcelas);
		for (int i = 1; i <= quantidadeParcelas.intValue(); i++) {
			dataVencimento = dataVencimento.plusMonths(1);
			parcelas.add(new Parcela(dataVencimento, valor, i, this));
		}
		this.parcelas.addAll(parcelas);
	}
	
	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void aprovar() {
		this.status = Status.APROVADA;
	}
	
	public Status getStatus() {
		return status;
	}

}
