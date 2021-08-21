package br.com.santander.gerenciadoremprestimo.service;

import org.springframework.stereotype.Service;

import br.com.santander.gerenciadoremprestimo.model.Cliente;
import br.com.santander.gerenciadoremprestimo.model.dto.ClienteInputDto;
import br.com.santander.gerenciadoremprestimo.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente criar(ClienteInputDto clienteDto) {
		Cliente cliente = clienteDto.converte();
		return clienteRepository.save(cliente);
	}

	public Cliente obterCliente(Integer id) {
		return clienteRepository.getById(id);
	}

}
