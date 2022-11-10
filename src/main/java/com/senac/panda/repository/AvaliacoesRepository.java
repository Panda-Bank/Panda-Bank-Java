package com.senac.panda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.panda.model.Avaliacoes;

@Repository
public interface AvaliacoesRepository extends  JpaRepository<Avaliacoes, Long>{
	
	public Optional<Avaliacoes> findById(long id);

}
