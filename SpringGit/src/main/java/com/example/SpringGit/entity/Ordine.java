package com.example.SpringGit.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

//TODO: change import utenti
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ordine")
public class Ordine implements Serializable {

	private static final long serialVersionUID = -1349444433762367778L;

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "DATA")
	private Date data;

	@Column(name = "NUM_ORDINE")
	private String numOrdine;
	
	@ManyToOne
	@JoinColumn(name="id_utente")
	private Utente utente;
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	public String getNumOrdine() {
		return numOrdine;
	}



	public void setNumOrdine(String num_ordine) {
		this.numOrdine = num_ordine;
	}


	@JsonIgnore
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@JsonProperty("id dell'utente")
	public int getIdUtente() {
		return utente.getId();
	}
	

}
