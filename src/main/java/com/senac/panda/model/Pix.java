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
@Table(name = "pix")
public class Pix {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pix;
	
	@NotBlank (message = "Esse campo não pode estar em branco")
	private String chave;
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	@JsonIgnoreProperties("pix")
	private Usuario usuarios;
	
}
