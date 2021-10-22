package com.example.SpringGit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "wishlist")
public class WishList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_articolo")
	private Articolo articolo;
	
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonIgnore
	public Articolo getArticolo() {
		return articolo;
	}

	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

	public int getIdArticolo() {
		return articolo.getId();
	}
	
	@JsonIgnore
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public int getIdUtente() {
		return utente.getId();
	}

	@Override
	public String toString() {
		return "WishList [id=" + id + ", articolo=" + articolo + ", utente=" + utente + "]";
	}
	
}
