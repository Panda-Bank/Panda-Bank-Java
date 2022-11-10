package com.senac.panda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.panda.model.Pix;
import com.senac.panda.repository.PixRepository;

@Service
public class PixService {
	@Autowired
	private PixRepository repository;
	
	public Optional<Object> cadastrarPix(Pix pix){
		return repository.findByChaveAndTipo(pix.getChave(), pix.getTipo()).map(resp ->{
			return Optional.empty();
		}).orElseGet(() ->{
			return Optional.ofNullable(repository.save(pix));
		});
	}
	
	public Optional<Pix> atualizarPix(Pix pix){
		return repository.findById(pix.getId()).map(resp ->{
			resp.setChave(pix.getChave());
			return Optional.ofNullable(repository.save(resp));
		}).orElseGet(() ->{
			return Optional.empty();
		});
	}
	

	

}
