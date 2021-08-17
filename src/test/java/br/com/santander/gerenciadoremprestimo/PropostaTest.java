package br.com.santander.gerenciadoremprestimo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

import br.com.santander.gerenciadoremprestimo.model.Cliente;
import br.com.santander.gerenciadoremprestimo.model.Proposta;

public class PropostaTest {

	@Test
	void criarPropostaTest() {
		Cliente cliente = new Cliente("Franklin Barreto", BigDecimal.valueOf(100000), LocalDate.of(2010, Month.SEPTEMBER, 10), BigDecimal.valueOf(11000), "12345698741");
		Proposta proposta = new Proposta(BigDecimal.valueOf(10000), BigDecimal.valueOf(3), 4, cliente);
		System.out.println(proposta.getTaxaJuros());
		assertEquals(BigDecimal.valueOf(11255.09), proposta.getMontante());
	}
}
