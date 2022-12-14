package com.senac.panda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.panda.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByCpf(String cpf);

	public Optional<Usuario> findById(long id);
	
	public Optional<Usuario> findByPixChave(String chave);

	public Optional<Usuario> findByConta(String conta);
	
}
