package com.example.SpringGit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringGit.entity.Utente;
import com.example.SpringGit.service.UtenteService;

@RestController
@RequestMapping("/api/utente")
public class UtenteController {
	
	@Autowired
	private UtenteService us;
	
	@GetMapping(value="/all", produces="application/json")
	public ResponseEntity<?> allUtente() {
		try {
			List<Utente> utenti = (List<Utente>) us.utentiAll();
			return new ResponseEntity<List<Utente>>(utenti, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path="/inserimento", consumes= {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> inserimentoUtente(@RequestBody Utente utente){
		System.out.println("\nRichiamato endopoint /api/utente/inserimento");
		try {
			String out = us.insertUtente(utente);
			return new ResponseEntity<String>(out, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
}
