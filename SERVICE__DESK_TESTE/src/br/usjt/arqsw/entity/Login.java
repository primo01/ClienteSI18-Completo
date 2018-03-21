package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


/**
 * 
 * @author Gabriel Ferreira Primo 81618660 SIN3AN-MCA
 */

@SuppressWarnings("serial")
public class Login implements Serializable{
	public static final String LOGADO = "logado";
	

	private String nome;
	
	@NotNull
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Login [nome=" + nome + ", senha=" + senha + "]";
	}
}



