package com.senac.panda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.panda.model.Pix;
import com.senac.panda.model.Usuario;

@Repository
public interface PixRepository extends JpaRepository<Pix, Long>{
	
	public Optional<Pix> findByChaveAndTipoChave(String chave, String tipo_chave);
}
