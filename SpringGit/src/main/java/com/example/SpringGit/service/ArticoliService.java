package com.example.SpringGit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringGit.entity.Articolo;
import com.example.SpringGit.repository.ArticoliRepository;


@Service
public class ArticoliService {
	@Autowired 
	private ArticoliRepository ar;
	
	
	
	public Articolo findById(int id)throws Exception{
		Optional<Articolo> pOptional = ar.findById(id);
		if(!pOptional.isPresent() ) {
			throw new Exception("BAD - Articolo non presente con questo Id.");
		}
		return pOptional.get();
	}
	
	public List<Articolo> findAllArticoli() throws Exception{
		List<Articolo> listaArticoli = ar.findAll();
		if(listaArticoli == null || listaArticoli.isEmpty()) {
			throw new Exception("BAD - Articoli non inseriti nel DB.");
		}
		return listaArticoli;
	}
	
	
	
	
	
	
}
