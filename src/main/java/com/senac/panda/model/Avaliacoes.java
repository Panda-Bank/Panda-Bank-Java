package com.senac.panda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "avaliacoes")
public class Avaliacoes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_comentario ;
	
	@NotBlank(message = "campo classificacao nao pode ser em branco")
	@Size(min = 5, max = 50)
	private String classificacao;
	
	@NotBlank(message = "campo texto nao pode ser em branco")
	@Size(min = 2, max = 40)
	private String texto;
	

}
