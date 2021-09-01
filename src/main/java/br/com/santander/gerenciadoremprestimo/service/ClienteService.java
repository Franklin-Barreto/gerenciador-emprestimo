package br.com.santander.gerenciadoremprestimo.service;

import java.util.List;

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

	public Cliente obter(Integer id) {
		return clienteRepository.getById(id);
	}

	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

}
