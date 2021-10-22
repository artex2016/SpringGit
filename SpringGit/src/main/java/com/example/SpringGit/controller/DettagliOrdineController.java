package com.example.SpringGit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringGit.service.DettagliOrdineService;

@RestController
@RequestMapping("/dettagliordini/api")
public class DettagliOrdineController {
	
	@Autowired
	private DettagliOrdineService dettagliOrdineService;
	
	@PostMapping("/new/{ordine}")
	public ResponseEntity<String> newDettaglioOrdine(@PathVariable("ordine")String ordine,@RequestBody Map<String,String> paramMap) {
		try {
			int qta=Integer.parseInt(paramMap.get("qta"));
			int articolo=Integer.parseInt(paramMap.get("articolo"));
			dettagliOrdineService.add(ordine,articolo,qta);
			return new ResponseEntity<>("OK - Dettaglio Ordine aggiunto",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(path="/modify/{dettaglioordine}",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> modifyDettaglioOrdine(@PathVariable("dettaglioordine")int dettaglioOrdine,@RequestBody Map<String,String> paramMap){
		try {
			dettagliOrdineService.modify(dettaglioOrdine, Integer.parseInt(paramMap.get("articolo")), paramMap.get("ordine"), Double.parseDouble(paramMap.get("prezzo")), Double.parseDouble(paramMap.get("iva")),Integer.parseInt(paramMap.get("qta")));
			return new ResponseEntity<>("OK - DettaglioOrdine modificato",HttpStatus.OK);			
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{dettaglioordine}")
	public ResponseEntity<String> deleteDettaglioOrdine(@PathVariable("dettaglioordine")int dettaglioOrdine){
		try {
			dettagliOrdineService.delete(dettaglioOrdine);
			return new ResponseEntity<>("OK - Dettaglio ordine eliminato",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	

}
