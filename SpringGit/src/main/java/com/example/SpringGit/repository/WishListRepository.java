package com.example.SpringGit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringGit.entity.WishList;
import com.example.SpringGit.entity.Articolo;
import com.example.SpringGit.entity.Utente;


public interface WishListRepository extends JpaRepository<WishList, Integer>{
	
	List<WishList> findByUtente(Utente u);
	
	long countByArticolo(Articolo a);
	
    void deleteByUtenteAndArticolo(Utente u, Articolo a);
}
