package com.example.SpringGit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringGit.entity.Articolo;
import com.example.SpringGit.entity.DettaglioOrdine;
import com.example.SpringGit.entity.Ordine;

@Repository
public interface DettagliOrdineRepository extends JpaRepository<DettaglioOrdine,Integer>{

	List<DettaglioOrdine >findByOrdine(Ordine o);
	
	List<DettaglioOrdine> findByArticolo(Articolo a);
	
}
