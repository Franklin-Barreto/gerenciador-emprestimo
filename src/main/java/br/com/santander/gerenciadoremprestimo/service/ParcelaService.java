package br.com.santander.gerenciadoremprestimo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.santander.gerenciadoremprestimo.model.Parcela;
import br.com.santander.gerenciadoremprestimo.repository.ParcelaRepository;

@Service
public class ParcelaService {

	private final ParcelaRepository parcelaRepository;

	public ParcelaService(ParcelaRepository parcelaRepository) {
		this.parcelaRepository = parcelaRepository;
	}

	public List<Parcela> saveAll(List<Parcela> parcelas) {
		return parcelaRepository.saveAll(parcelas);
	}

}
