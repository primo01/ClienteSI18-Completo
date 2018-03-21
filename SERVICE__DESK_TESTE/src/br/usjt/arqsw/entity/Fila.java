package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




/**
 * 
 * @author Gabriel Ferreira Primo 81618660 | USJT MOOCA
 *
 */

@Entity
@Table(name="fila")
public class Fila implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name="id")
	@NotNull(message="A fila n�o pode ser vazia")
	@Min(value=1, message="A fila n�o pode ser vazia")
	private int id;
	
	@Column(name="nome")
	@NotNull
	@Size(min=5, max=45, message="O nome da fila deve estar entre 5 e 45 caracteres.")
	private String nome;
	

	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Fila [id=" + id + ", nome=" + nome + "]";
	}
	
}
