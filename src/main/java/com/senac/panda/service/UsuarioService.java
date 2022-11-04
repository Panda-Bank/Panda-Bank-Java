package com.senac.panda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.panda.model.Usuario;
import com.senac.panda.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Object> cadastrarUsuario(Usuario usuario){
		return repository.findByCpf(usuario.getCpf()).map(usuarioExistente ->{
			return Optional.empty();		
		}).orElseGet(() ->{
			return Optional.ofNullable(repository.save(usuario));
		});
	
	}
}
