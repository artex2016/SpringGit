package com.example.SpringGit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringGit.entity.Articolo;
import com.example.SpringGit.entity.Carrello;
import com.example.SpringGit.entity.Utente;
import com.example.SpringGit.repository.CarrelloRepository;

@Service
public class CarrelloService {

	@Autowired 
	private CarrelloRepository rep;
	
	public Carrello findById(int id)throws Exception{
		Optional<Carrello> pOptional = rep.findById(id);
		if(!pOptional.isPresent() ) {
			throw new Exception("BAD - Carrello non presente con questo Id.");
		}
		return pOptional.get();
	}
	
	public List<Carrello> findByUtente(Utente utente) throws Exception{
		List<Carrello> listaCarrelli = rep.findByUtente(utente);
		if(listaCarrelli == null || listaCarrelli.isEmpty()) {
			throw new Exception("BAD - Nessun carrello per questo utente.");
		}
		return listaCarrelli;
	}
}
