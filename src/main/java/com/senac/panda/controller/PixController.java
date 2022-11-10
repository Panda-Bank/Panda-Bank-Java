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

import com.senac.panda.model.Pix;
import com.senac.panda.repository.PixRepository;
import com.senac.panda.service.PixService;


@RestController
@RequestMapping("/pix")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PixController {

	@Autowired
	PixRepository repository;
	
	@Autowired 
	private PixService service;
	
	@GetMapping
	public ResponseEntity<List<Pix>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	@GetMapping("{fk}")
	public ResponseEntity<List<Pix>> getAllByFk(@PathVariable long fk){
		return ResponseEntity.ok(repository.findAllByUsuariosId(fk));
		
	}
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrar (@Valid @RequestBody Pix pix){
		return service.cadastrarPix(pix).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Pix existente, cadastre outra chave!.");

		});
	}
	@PutMapping("/atualizar")
	public ResponseEntity<Pix> atualizar (@RequestBody Pix pix){
		return service.atualizarPix(pix).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Pix inexistente, informe uma chave e tipo válidos!.");

		});
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
	
}
	

