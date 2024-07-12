package it.spring.Pizzeria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity 
@Table (name = "Menu")
public class Menu {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Integer id;
	
	@Column(name= "nome", nullable=false)
	private String nome;
	
	@Column(name= "descrizione", nullable=false)
	private String descrizione;
	
	@Column(name= "foro_url", nullable=true)
	private String foto;  /*URL*/
	
	private float prezzo;
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
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	

}
