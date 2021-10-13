package com.example.SpringGit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringGit.entity.Articolo;
import com.example.SpringGit.entity.Carrello;
import com.example.SpringGit.entity.Utente;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Integer> {
	
	public Optional<Carrello> findById(int id);
	public List<Carrello> findByUtente(Utente utente);
	public List<Carrello> findByArticolo(Articolo articolo);

}
