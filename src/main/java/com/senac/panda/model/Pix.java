package com.senac.panda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pix")
public class Pix {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pix;
	
	@NotBlank
	private String chave;
	
//	@ManyToOne
//	@JoinColumn(name = "fk_usuario_conta_id_usuario")
//	private long fk_usuario_conta_id_usuario;
	
}
