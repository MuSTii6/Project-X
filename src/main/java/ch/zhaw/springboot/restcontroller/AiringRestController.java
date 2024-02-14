package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Airing;
import ch.zhaw.springboot.repositories.AiringRepository;


@RestController
public class AiringRestController {

    
    @Autowired													// Macht Getter im Repo unnötig, tutt dies automatisch wenn RestController erstelltw ird
    private AiringRepository airingRepository;

    @RequestMapping(value = "airings", method = RequestMethod.GET)
	public ResponseEntity<List<Airing>> getAirings() {
		List<Airing> airings = this.airingRepository.findAll();

		if (!airings.isEmpty()) {
			return new ResponseEntity<List<Airing>>(airings, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Airing>>(HttpStatus.NOT_FOUND);
		}
	}

    @RequestMapping(value = "airings/{id}", method = RequestMethod.GET)
	public ResponseEntity<Airing> getairingsById(@PathVariable("id") long id) {
		Optional<Airing> airing = airingRepository.findById(id);

		if (airing.isPresent()) {
			return new ResponseEntity<Airing>(airing.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Airing>(HttpStatus.NOT_FOUND);
		}
	}
}
