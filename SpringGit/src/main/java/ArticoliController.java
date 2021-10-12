import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringGit.entity.Articolo;
import com.example.SpringGit.service.ArticoliService;

@RestController
@RequestMapping("/api/articolo")
public class ArticoliController {

	@Autowired
	private ArticoliService as;
	
	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<List<Articolo>> allUArticoli() {
		List<Articolo> dati;
		try {
			dati = as.findAllArticoli();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(dati, HttpStatus.OK);
	}

	@GetMapping(value = "/id/{id}", produces = "application/json")
	public ResponseEntity<Articolo> utentiFindById(@PathVariable("id") int id) {

		Articolo articolo;
		try {
			articolo = as.findById(id);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(articolo, HttpStatus.OK);
	}
	

}
