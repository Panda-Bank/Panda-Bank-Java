package com.senac.panda.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.panda.email.EmailMessages;
import com.senac.panda.email.EnviarEmailService;
import com.senac.panda.model.Pix;
import com.senac.panda.model.Transferencia;
import com.senac.panda.model.Usuario;
import com.senac.panda.repository.PixRepository;
import com.senac.panda.repository.TransferenciaRepository;
import com.senac.panda.repository.UsuarioRepository;

@Service
public class PixService {
	@Autowired
	private PixRepository repository;

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private EnviarEmailService email;

	@Autowired
	private TransferenciaRepository transferenciaRepo;

	@Autowired
	private UsuarioService userService;

	public Optional<Object> cadastrarPix(Pix pix) {
		return repository.findByChaveAndTipo(pix.getChave(), pix.getTipo()).map(resp -> {
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(repository.save(pix));
		});
	}

	public Optional<Pix> atualizarPix(Pix pix) {
		return repository.findById(pix.getId()).map(resp -> {
			resp.setChave(pix.getChave());
			return Optional.ofNullable(repository.save(resp));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

	@Transactional
	public Optional<Transferencia> transferir(Transferencia transferencia) {

		return usuarioRepo.findByPixChave(transferencia.getChave()).map(resp -> {
			Optional<Usuario> usuarioEnvia = usuarioRepo.findById(transferencia.getUsuario().getId());

			transferencia.getUsuario().setSaldo((transferencia.getUsuario().getSaldo()) - (transferencia.getValor()));
			userService.atualizarSaldo(resp, transferencia.getValor(), true);

			userService.atualizarSaldo(transferencia.getUsuario(), transferencia.getValor(), false);

			transferenciaRepo.save(transferencia);
			email.enviar(usuarioEnvia.get().getEmail(), EmailMessages.createTitle(usuarioEnvia.get()),
					EmailMessages.mensagemDeTransferencia(transferencia, usuarioEnvia.get()));
			return Optional.ofNullable(transferencia);
		}).orElseGet(() -> {
			return Optional.empty();
		});

	}

}
