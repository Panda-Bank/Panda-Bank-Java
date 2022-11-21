package com.senac.panda.controller;

import java.util.List;
import java.util.Optional;

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
	
	@PostMapping("/logar")
	public ResponseEntity<Usuario> login(@RequestBody Optional<Usuario> usuario){
		return service.logar(usuario).map(resp ->
			ResponseEntity.ok(resp))
		.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrar(@Valid @RequestBody Usuario usuario) {
		return service.cadastrarUsuario(usuario).map(retorno -> ResponseEntity.status(201).body(retorno))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Usuario existente, cadastre outro usuario!.");

				});
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable long id){
		return repository.findById(id).map(retorno ->ResponseEntity.status(200).body(retorno))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.NO_CONTENT,
							"Usuario não encontrado, informe um CPF válido!");

				});
	
	}
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Usuario> getByCPF(@PathVariable String cpf){
		return repository.findByCpf(cpf).map(retorno ->ResponseEntity.status(200).body(retorno))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.NO_CONTENT,
							"Usuario não encontrado, informe um CPF válido!");

				});
	
	}
	@GetMapping("/chave/{chave}")
	public ResponseEntity<Usuario> getByChave(@PathVariable String chave){
		return repository.findByPixChave(chave).map(retorno ->ResponseEntity.status(200).body(retorno))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.NO_CONTENT,
							"Chave não encontrada, informe uma chave válida!");

				});
	
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
