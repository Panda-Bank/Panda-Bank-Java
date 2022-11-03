package com.senac.panda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "poupanca")
public class Poupanca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_poupanca;

	@NotBlank(message = "Poupança não pode estar vazia")
	private String saldo_poupanca;

	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	@JsonIgnoreProperties("poupancas")
	private Usuario usuarios;


}
