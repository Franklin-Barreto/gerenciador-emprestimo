package br.com.santander.gerenciadoremprestimo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.santander.gerenciadoremprestimo.model.Cliente;
import br.com.santander.gerenciadoremprestimo.model.dto.ClienteInputDto;
import br.com.santander.gerenciadoremprestimo.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criar(@RequestBody ClienteInputDto clienteDto) {
		
		Cliente cliente = clienteService.criar(clienteDto);
		URI uri = UriComponentsBuilder.fromPath("clientes/{id}").buildAndExpand(cliente .getId()).toUri();
		return ResponseEntity.created(uri ).body(cliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
		return ResponseEntity.ok(this.clienteService.obter(id));
	}
	
	@GetMapping("/buscartodos")
	public List<Cliente> buscarTodos(){
		return clienteService.buscarTodos();
	}
	
	
}
