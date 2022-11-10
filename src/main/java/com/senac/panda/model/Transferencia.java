package com.senac.panda.model;

public class Transferencia {

	private long id;
	
	private double valor;
	
	private Usuario usuarioEnvia;
	
	private Usuario UsuarioRecebe;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Usuario getUsuarioEnvia() {
		return usuarioEnvia;
	}

	public void setUsuarioEnvia(Usuario usuarioEnvia) {
		this.usuarioEnvia = usuarioEnvia;
	}

	public Usuario getUsuarioRecebe() {
		return UsuarioRecebe;
	}

	public void setUsuarioRecebe(Usuario usuarioRecebe) {
		UsuarioRecebe = usuarioRecebe;
	}
	
	
}
