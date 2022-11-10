package com.senac.panda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.panda.model.Pix;

@Repository
public interface PixRepository extends JpaRepository<Pix, Long>{
	
	public Optional<Pix> findByChaveAndTipo(String chave, String tipo);

	public Optional<Pix> findById(long id);
	
	public Optional<Pix> findByChave(String chave);
	
	public List<Pix> findAllByUsuariosId(long fk);
}
