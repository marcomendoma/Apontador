package com.apontador.CrudApontador.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Marco Antonio Mendonça
 * 
 *         Endereco - Representa a entidade de localidade no banco de dados.
 *
 */

@Entity
@Table(name = "localidade")
public class Localidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_localidade", sequenceName = "seq_localidade", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_localidade")
	private Long id;

	@NotNull(message = "Campo nome do local é obrigatório.")
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@NotNull(message = "Campo fone é obrigatório.")
	@Column(name = "fone", length = 14, nullable = false)
	private String fone;

	@NotNull(message = "Campo endereco é obrigatório.")
	@Column(name = "endereco", length = 150, nullable = false)
	private String endereco;

	public Localidade() {
	}

	public Localidade(String nome, String fone, String endereco) {
		this.nome = nome;
		this.fone = fone;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidade other = (Localidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Localidade [id=" + id + ", nome=" + nome + ", fone=" + fone + ", endereco=" + endereco + "]";
	}
}
