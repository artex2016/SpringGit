package com.example.SpringGit.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringGit.entity.Ordine;
import com.example.SpringGit.entity.Utente;



@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Integer> {

	// ricerca in database con metodi di jpa
	List<Ordine> findByUtente(Utente utente);
	
	Optional<Ordine> findByNumOrdine(String num_ordine);
	
	List<Ordine> findByData(Date dataOrdine);
	
}
