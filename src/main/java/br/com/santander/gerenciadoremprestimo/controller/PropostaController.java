package br.com.santander.gerenciadoremprestimo.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.santander.gerenciadoremprestimo.model.Proposta;
import br.com.santander.gerenciadoremprestimo.model.dto.PropostaInputDto;
import br.com.santander.gerenciadoremprestimo.service.PropostaService;

@RestController
@RequestMapping("propostas")
public class PropostaController {

	private final PropostaService propostaService;
	public PropostaController(PropostaService propostaService) {
		this.propostaService = propostaService;
	}
	
	@PostMapping
	public ResponseEntity<Proposta>criar(@RequestBody PropostaInputDto propostaDto){
		PropostaInputDto propostaInput = propostaDto;
		Proposta proposta = propostaService.criarProposta(propostaInput);
		URI uri = UriComponentsBuilder.fromPath("propostas/{id}").buildAndExpand(proposta.getId()).toUri();
		return ResponseEntity.created(uri).body(proposta);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Proposta> aprovarProposta(@PathVariable Integer id){
		Proposta proposta = propostaService.aprovar(id);
		return ResponseEntity.ok(proposta);
	}
}