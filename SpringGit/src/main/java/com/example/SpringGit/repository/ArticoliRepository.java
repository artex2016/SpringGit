package com.example.SpringGit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringGit.entity.Articolo;

public interface ArticoliRepository extends JpaRepository<Articolo, Integer> {
	
	

}
