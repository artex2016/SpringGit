package com.example.SpringGit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringGit.entity.Utente;
import com.example.SpringGit.repository.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteRepository ur;
	
	public List<Utente> utentiAll() throws Exception{
		List<Utente> listaUtenti = ur.findAll();
		if (listaUtenti == null || listaUtenti.isEmpty()) {
			throw new Exception("BAD - Nessun utente presente nel DB");
		}
		return listaUtenti;
	}
	
	public Utente findById(int id) throws Exception {
		Optional<Utente> uOptional = ur.findById(id);
		if(!uOptional.isPresent()) {
			throw new Exception("BAD - Utente non presente con questo Id");
		}
		return uOptional.get();
	}
	
	@Transactional
	public String insertUtente(Utente u) throws Exception {
		ur.save(u);
		return "OK - utente inserito";
	}
	
	
}
