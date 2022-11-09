package com.senac.panda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.senac.panda.model.Pix;
import com.senac.panda.repository.PixRepository;
import com.senac.panda.service.PixService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/pix")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PixController {

	@Autowired
	PixRepository repository;
	
	@Autowired 
	private PixService service;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrar (@Valid @RequestBody Pix pix){
		return service.cadastrarPix(pix).map(retorno -> ResponseEntity.status(200).body(retorno))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Pix existente, cadastre outra chave!.");

		});
	}
	
	@GetMapping
	public ResponseEntity<List<Pix>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	
	
}
	

