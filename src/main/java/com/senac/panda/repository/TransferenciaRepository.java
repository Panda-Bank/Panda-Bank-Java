package com.senac.panda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.panda.model.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{

}
