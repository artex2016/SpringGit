package com.example.SpringGit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringGit.entity.Utente;


@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{

	
	//TEMPORARY
}
