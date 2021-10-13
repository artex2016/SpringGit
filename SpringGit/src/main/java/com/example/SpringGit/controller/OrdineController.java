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

import com.example.SpringGit.entity.Ordine;
import com.example.SpringGit.service.OrdineService;


@RestController
@RequestMapping("/api/ordine")
public class OrdineController {

	@Autowired
	private OrdineService ordineServ;
	
	@GetMapping(value="/all", produces="application/json")
	public ResponseEntity<List<Ordine>> allOrdine() {
		List<Ordine> dati = (List<Ordine>) ordineServ.ordiniAll();
		return new ResponseEntity<>(dati, HttpStatus.OK);
	}

	// Inserimento post con id utente passato per path
	@PostMapping(path = "/inserimento/{id}", consumes = { MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> inserimentoPost(@PathVariable("id") int id, @RequestBody Ordine ordine) {

		System.out.println("\nRichiamato endpoint /api/post/inserimento/" + id);

		try {

			String out = ordineServ.insertOrdine(ordine, id);
			return new ResponseEntity<>(out, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
}
