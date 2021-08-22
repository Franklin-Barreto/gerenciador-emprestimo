package br.com.santander.gerenciadoremprestimo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

import br.com.santander.gerenciadoremprestimo.model.Cliente;
import br.com.santander.gerenciadoremprestimo.model.Proposta;

import static org.junit.jupiter.api.Assertions.*;

public class PropostaTest {

	@Test
	void criarPropostaTest() {
		Cliente cliente = new Cliente("Franklin Barreto", BigDecimal.valueOf(100000),
				LocalDate.of(2010, Month.SEPTEMBER, 10), BigDecimal.valueOf(11000), "12345698741");
		Proposta proposta = new Proposta(BigDecimal.valueOf(10000), BigDecimal.valueOf(3), 4, cliente);
		assertEquals(BigDecimal.valueOf(11255.09), proposta.getMontante());
	}

	@Test
	void clienteElegivelPropostaParcelaMaiorQue30PorcentoTest() {
		Cliente cliente = new Cliente("Franklin Barreto", BigDecimal.valueOf(1000), LocalDate.of(2010, Month.SEPTEMBER, 10), BigDecimal.valueOf(10000), "12345698741");
		Proposta proposta = new Proposta(BigDecimal.valueOf(10000), BigDecimal.valueOf(3), 4, cliente);
		assertFalse(proposta.isClienteElegivel());
	}

	@Test
	void clienteElegivelPropostaSemTempoCasaTest() {
		Cliente cliente = new Cliente("Franklin Barreto", BigDecimal.valueOf(1000), LocalDate.of(2021, Month.AUGUST, 10), BigDecimal.valueOf(10000), "12345698741");
		Proposta proposta = new Proposta(BigDecimal.valueOf(1000), BigDecimal.valueOf(3), 4, cliente);
		assertFalse(proposta.isClienteElegivel());
	}

}
