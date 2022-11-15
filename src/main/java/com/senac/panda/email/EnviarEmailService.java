package com.senac.panda.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EnviarEmailService {

	@Autowired
	private final JavaMailSender envioEmailDoJava;
	
	public EnviarEmailService(final JavaMailSender javaMailSender) {
		this.envioEmailDoJava = javaMailSender;
	}
	
	public void enviar(String para, String titulo, String conteudo) {
	
		var mensagem = new SimpleMailMessage();
		
		mensagem.setTo(para);
		mensagem.setSubject(titulo);
		mensagem.setText(conteudo);
		envioEmailDoJava.send(mensagem);
		
	}
	
	
	
	
}
