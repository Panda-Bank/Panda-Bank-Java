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
	private long id;
	
	@NotBlank (message = "Campo chave não pode estar em branco")
	private String chave;
	
	@NotBlank (message = "Campo chave não pode estar em branco")
	private String tipoChave;
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	@JsonIgnoreProperties("pix")
	private Usuario usuarios;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChave() {
		return chave;
	}

	

	public String getTipoChave() {
		return tipoChave;
	}

	public void setTipoChave(String tipoChave) {
		this.tipoChave = tipoChave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}



	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	
	
	
}
