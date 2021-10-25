package com.example.SpringGit.controller;

import java.util.List;
import java.util.Map;

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

import com.example.SpringGit.entity.WishList;
import com.example.SpringGit.service.WishListService;

@RestController
@RequestMapping("/api/wish-list")
public class WishListController {
	
	@Autowired
	private WishListService wishListService;
	
	@GetMapping(value = "/utente/{id_utente}", produces = "application/json")
	public ResponseEntity<List<WishList>> wishListUser(@PathVariable("id_utente") int id_utente) {
		List<WishList> dati;
		try {
			dati = (List<WishList>) wishListService.wishListUtente(id_utente);
			return new ResponseEntity<List<WishList>> (dati, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(path = "/new", consumes = { MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addToWishList(@RequestBody Map<String, Integer> newWishListForm) {
		try {
			wishListService.addToWishList(newWishListForm.get("id_utente"), newWishListForm.get("id_articolo"));
			return new ResponseEntity<String>("Articolo inserito correttamente", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("ERRORE nell'inserimento: " + e.getMessage(), HttpStatus.CONFLICT);
		}
	}
}
