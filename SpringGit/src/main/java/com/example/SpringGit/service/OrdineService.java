package com.example.SpringGit.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringGit.entity.Ordine;
import com.example.SpringGit.entity.Utente;
import com.example.SpringGit.repository.OrdineRepository;
import com.example.SpringGit.repository.UtenteRepository;

@Service
public class OrdineService {

	@Autowired
	private OrdineRepository ordineRepo;
	@Autowired
	private UtenteRepository utenteRepo;
	
	public List<Ordine> findByIdUtente(int idUtente) throws Exception{
		Optional<Utente> utente = utenteRepo.findById(idUtente);
		if(!utente.isPresent() ) {
			throw new Exception("BAD - Utente non presente con questo Id.");
		}
		return ordineRepo.findByUtente(utente.get());
	}
	
	public Optional<Ordine> findByNumOrdine(String numOrdine){
		return ordineRepo.findByNumOrdine(numOrdine);
	}
	
	public List<Ordine> findByData(Date dataOrdine){
		return ordineRepo.findByData(dataOrdine);
	}
	
	public Optional<Ordine> findById(int id){
		return ordineRepo.findById(id);
	}
	
	public List<Ordine> ordiniAll(){
		return ordineRepo.findAll();
	}
	
	@Transactional
	public String insertOrdine(Ordine ordine)  throws Exception {
		
		//TODO: check unicità dati
		int idOrdine = ordine.getId();
		if (ordineRepo.findById(idOrdine).isPresent())
			throw new Exception("BAD - Id ordine già presente.");
		
		Optional<Utente> utenteOpt = utenteRepo.findById(ordine.getIdUtente());
		if(!utenteOpt.isPresent())
			throw new Exception("BAD - Utente non presente con questo Id.");
		
		ordine.setUtente(utenteOpt.get());
		ordineRepo.save(ordine);
		
		return "OK - ordine inserito";
	}
	
	// modifica ordine
	
	
	// cancella ordine
	
	
}
