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
		return repository.findByChaveAndTipoChave(pix.getChave(), pix.getTipoChave()).map(resp ->{
			return Optional.empty();
		}).orElseGet(() ->{
			return Optional.ofNullable(repository.save(pix));
		});
	}
	
	

}
