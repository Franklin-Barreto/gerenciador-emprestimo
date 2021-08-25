package br.com.santander.gerenciadoremprestimo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.gerenciadoremprestimo.model.Usuario;
import br.com.santander.gerenciadoremprestimo.repository.UsuarioRepository;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}
}
