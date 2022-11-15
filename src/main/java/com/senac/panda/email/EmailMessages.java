package com.senac.panda.email;

import com.senac.panda.model.Transferencia;
import com.senac.panda.model.Usuario;

public class EmailMessages {

	public static String createTitle(Usuario usuario) {
		return
		usuario.getNome().split(" ")[0] + " seu pix foi enviado.";
		
}
	
	public static String mensagemDeTransferencia(Transferencia tranferencia, Usuario usuario) {
		return "Pix enviado com sucesso!\n"
				+"Você enviou: "
				+tranferencia.getValor()+"\n"
				+"Para: "+ usuario.getNome().split(" ")[0];
	}
}