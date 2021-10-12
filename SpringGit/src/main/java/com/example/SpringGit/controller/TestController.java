package come.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Commento inutile prova ric 2
// indichiamo che la classe è un controller eche non facciamo uso di template engine
@RestController

// indichiamo che tutti gli endpoint risponderanno a localhost:nomeporta/api/...
@RequestMapping("/api")

// indichiamo al ws di accettare tutte le richiesta da http://localhost:8050
//@CrossOrigin(origins="http://localhost")
public class TestController {
	
	// primo endpoint
	@GetMapping(value="/test")
	public String getTestQualunque() {
		
		return "\"Sono il webService!\"";
	}
	
	// endPoint con parametro
	@GetMapping(value="/test/{nome}")
	public String testConParametro(@PathVariable("nome") String valRicevuto)
	{
		return "\"Ciao " + valRicevuto + " Sono il webService!\"";
	}
	

}
