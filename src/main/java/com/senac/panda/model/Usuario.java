package com.senac.panda.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario_conta")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "campo nome nao pode ser em branco")
	@Size(min = 5, max =50)
	private String nome;
	
	@NotBlank (message = "campo cpf nao pode ser em branco")
	@Size(min = 7, max = 20 )
	private String cpf;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_nascimento;
	
	@NotBlank (message = "campo email não pode ser em branco")
	@Size(min = 10, max = 50)
	private String email;
	
	@NotBlank (message = "campo senha não pode ser em branco")
	@Size(min = 8, max = 20)
	private String senha;
	
	@NotBlank (message = "campo telefone não pode ser em branco")
	@Size(min = 8, max = 15)
	private String telefone;
	
	@NotBlank (message = "campo logradouro não pode ser em branco")
	@Size(min = 8, max = 30)
	private String logradouro;
	
	@NotBlank (message = "campo CEP não pode ser em branco")
	@Size(min = 8, max = 9)
	private String cep;
	
	@NotBlank (message = "campo numero enderenço não pode ser em branco")
	@Size(min = 1, max = 20)
	private String numero_endereco;
	
	@Size(min = 2, max = 20)
	private String complemento;
	
	@SuppressWarnings("unused")
	private double saldo = 600.0;
	
	@NotBlank (message = "campo agencia não pode ser em branco")
	@Size(min = 4, max = 4)
	private String agencia;
	
	@NotBlank (message = "campo conta não pode ser em branco")
	@Size(min = 5, max = 10)
	private String conta;
	
	@OneToMany(mappedBy ="usuarios", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"usuarios"})
	private List<Avaliacoes> avaliacoes = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuarios", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"usuarios"})
	private List<Poupanca> poupancas = new ArrayList<>();
	
	@OneToMany(mappedBy ="usuarios", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuarios")
	private List<Pix> pix = new ArrayList<>();
	
	@OneToMany(mappedBy ="usuarios", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"usuarios"})
	private List<Contatos> contatos = new ArrayList<>();
	
	//@OneToMany(mappedBy = "usuarioEnvia", cascade =  CascadeType.REMOVE)
	//@JsonIgnoreProperties({"usuarioEnvia"})
	//private List<Transferencia> transferencia = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Poupanca> getPoupancas() {
		return poupancas;
	}

	public void setPoupancas(List<Poupanca> poupancas) {
		this.poupancas = poupancas;
	}

	public List<Pix> getPix() {
		return pix;
	}

	public void setPix(List<Pix> pix) {
		this.pix = pix;
	}

	public List<Contatos> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contatos> contatos) {
		this.contatos = contatos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero_endereco() {
		return numero_endereco;
	}

	public void setNumero_endereco(String numero_endereco) {
		this.numero_endereco = numero_endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public List<Avaliacoes> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacoes> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	
	
	
	
	
	
	
	

}
