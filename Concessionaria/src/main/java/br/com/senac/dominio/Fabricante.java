package br.com.senac.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fabricante implements Serializable {

	private static final long serialVersionUID = 5592121442484238145L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@OneToMany(mappedBy="fabricante")
	private List<Carro> carro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Carro> getCarro() {
		return carro;
	}

	public void setCarro(List<Carro> carro) {
		this.carro = carro;
	}	
}
