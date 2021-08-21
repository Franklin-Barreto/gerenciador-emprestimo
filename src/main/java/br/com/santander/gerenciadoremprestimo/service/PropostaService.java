package br.com.santander.gerenciadoremprestimo.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.santander.gerenciadoremprestimo.model.Cliente;
import br.com.santander.gerenciadoremprestimo.model.Proposta;
import br.com.santander.gerenciadoremprestimo.model.dto.PropostaInputDto;
import br.com.santander.gerenciadoremprestimo.repository.PropostaRepository;
@Service
public class PropostaService {

	private final PropostaRepository propostaRepository;
	private final ClienteService clienteService;
	private final ParcelaService parcelaService;
	
	public PropostaService(PropostaRepository propostaRepository, ClienteService clienteService, ParcelaService parcelaService) {
		this.propostaRepository = propostaRepository;
		this.clienteService = clienteService;
		this.parcelaService = parcelaService;
	}

	@Transactional
	public Proposta criarProposta(PropostaInputDto propostaInput) {
		Cliente cliente = clienteService.obterCliente(propostaInput.getClienteId());
		Proposta proposta = propostaInput.converte(cliente);
		Proposta save = propostaRepository.save(proposta);
		parcelaService.saveAll(proposta.getParcelas());
		return save; 
	}

	@Transactional
	public Proposta aprovar(Integer id) {
		Proposta proposta = propostaRepository.getById(id);
		proposta.aprovar();
		return proposta;
	}

}
