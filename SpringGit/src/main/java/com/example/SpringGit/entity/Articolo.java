package com.example.SpringGit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articoli")
public class Articolo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "DESCRIZIONE")
	private String descrizione;
	@Column(name = "CODICE")
	private String codice;
	@Column(name = "PREZZO")
	private double prezzo;
	@Column(name = "IVA")
	private double iva;
	
	
	
	
	
	
	
	
}
