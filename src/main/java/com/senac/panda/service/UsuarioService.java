package com.senac.panda.service;

import java.util.Optional;

import javax.transaction.Transactional;

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
	
	
	public Optional<Usuario> atualizarUsuario(Usuario usuario){
		return repository.findByCpf(usuario.getCpf()).map(usuarioExistente ->{
			usuarioExistente.setNome(usuario.getNome());
			usuarioExistente.setCpf(usuario.getCpf());
			usuarioExistente.setData_nascimento(usuario.getData_nascimento());
			usuarioExistente.setEmail(usuario.getEmail());
			usuarioExistente.setSenha(usuario.getSenha());
			usuarioExistente.setTelefone(usuario.getTelefone());
			usuarioExistente.setLogradouro(usuario.getLogradouro());
			usuarioExistente.setCep(usuario.getCep());
			usuarioExistente.setNumero_endereco(usuario.getNumero_endereco());
			usuarioExistente.setComplemento(usuario.getComplemento());
			return Optional.ofNullable(repository.save(usuarioExistente));					
		}).orElseGet(() ->{
			return Optional.empty();
		});
	
	}
	
	@Transactional
	public Optional<Usuario> atualizarSaldo(Usuario usuario, double valor, boolean adicionar){
		return repository.findById(usuario.getId()).map(usuarioExistente ->{
			if(adicionar == true) {
				usuarioExistente.setSaldo(usuarioExistente.getSaldo() + valor);
			}else {
				usuarioExistente.setSaldo(usuarioExistente.getSaldo() - valor);
			}
			
			return Optional.ofNullable(repository.save(usuarioExistente));					
		}).orElseGet(() ->{
			return Optional.empty();
		});
	
	}
	
}
