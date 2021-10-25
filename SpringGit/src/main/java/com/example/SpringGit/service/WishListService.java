package com.example.SpringGit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringGit.entity.Articolo;
import com.example.SpringGit.entity.Utente;
import com.example.SpringGit.entity.WishList;
import com.example.SpringGit.repository.ArticoliRepository;
import com.example.SpringGit.repository.UtenteRepository;
import com.example.SpringGit.repository.WishListRepository;

@Service
public class WishListService {
	
	@Autowired
	private WishListRepository wishListRepository;

	@Autowired
	private UtenteRepository userRepository;
	
	@Autowired
	private ArticoliRepository articoloRepository;
	
	public List<WishList> wishListUtente(int id_utente) throws Exception {
		Utente utente = userRepository.findById(id_utente).get();
		if (utente == null) {
			throw new Exception("L'id utente non e' valido");
		}
		return wishListRepository.findByUtente(utente);
	}

	@Transactional
	public void addToWishList(int id_utente, int id_articolo) throws Exception {
		Utente utente = userRepository.findById(id_utente).get();
		if (utente == null) {
			throw new Exception("L'id utente non e' valido");
		}
		Articolo articolo = articoloRepository.findById(id_articolo).get();
		if (articolo == null) {
			throw new Exception("L'id articolo non e' valido");
		}
		
		List<WishList> wishListUtente = wishListUtente(utente.getId());
		
		for (WishList wl : wishListUtente) {
			if (wl.getArticolo().equals(articolo)) {
				throw new Exception("Articolo già presente nella wishlist dell'utente");				
			}
		}
		
		WishList newElement = new WishList();
		newElement.setArticolo(articolo);
		newElement.setUtente(utente);
		
		wishListRepository.save(newElement);
	}

	@Transactional
	public void removeFromWishList(int id) throws Exception {
		if (!wishListRepository.existsById(id)) {
			throw new Exception("Il record con id " + id + " non esiste.");
		}
		wishListRepository.deleteById(id);
	}
}
