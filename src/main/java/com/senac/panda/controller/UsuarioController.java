package com.senac.panda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.senac.panda.model.Usuario;
import com.senac.panda.repository.UsuarioRepository;
import com.senac.panda.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioService service;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrar(@Valid @RequestBody Usuario usuario) {
		return service.cadastrarUsuario(usuario).map(retorno -> ResponseEntity.status(200).body(retorno))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Usuario existente, cadastre outro usuario!.");

				});
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizar (@RequestBody Usuario usuario){
		return service.atualizarUsuario(usuario).map(retorno -> ResponseEntity.status(201).body(retorno))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Usuario inexistente, informe um CPF válido!.");

				});
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
}
