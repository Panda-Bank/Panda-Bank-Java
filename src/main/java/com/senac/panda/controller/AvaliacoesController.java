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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.senac.panda.model.Avaliacoes;
import com.senac.panda.repository.AvaliacoesRepository;
import com.senac.panda.service.AvaliacoesService;

@RestController
@RequestMapping("/avaliacoes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AvaliacoesController {

	@Autowired
	private AvaliacoesRepository repository;
	
	@Autowired
	private AvaliacoesService service;
	
	
	@GetMapping
	public ResponseEntity<List<Avaliacoes>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Object> criar(@Valid @RequestBody Avaliacoes avaliacao){
		return service.cadastrarAvaliacao(avaliacao).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() ->{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Avaliação já existente!.");

				});
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
