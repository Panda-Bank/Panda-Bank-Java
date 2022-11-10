package com.senac.panda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.panda.model.Avaliacoes;
import com.senac.panda.repository.AvaliacoesRepository;

@Service
public class AvaliacoesService {

	@Autowired
	private AvaliacoesRepository repository;
	
	public Optional<Object> cadastrarAvaliacao(Avaliacoes avaliacoes){
		return repository.findById(avaliacoes.getId()).map(resp ->{
			return Optional.empty();
		}).orElseGet(() ->{
			return Optional.ofNullable(repository.save(avaliacoes));
		});
	}
	
}
