package ch.zhaw.springboot.restcontroller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Concert;
import ch.zhaw.springboot.repositories.ConcertRepository;

@RestController
public class ConcertRestController {

  
    @Autowired
    private ConcertRepository concertRepository;

    @RequestMapping(value = "concerts", method = RequestMethod.GET)
	public ResponseEntity<List<Concert>> getConcerts() {
		List<Concert> concerts = concertRepository.findAll();

		if (!concerts.isEmpty()) {
			return new ResponseEntity<List<Concert>>(concerts, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Concert>>(HttpStatus.NOT_FOUND);
		}
	}

    @RequestMapping(value = "concerts/{id}", method = RequestMethod.GET)
	public ResponseEntity<Concert> getconcertsById(@PathVariable("id") long id) {
    	Optional<Concert> concert = concertRepository.findById(id);

		if (concert.isPresent()) {
			return new ResponseEntity<Concert>(concert.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Concert>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "concerts/withoutlocation", method = RequestMethod.GET)
	public ResponseEntity<List<Concert>> getConcertsWithoutLocation() {
		List<Concert> concerts = concertRepository.findAllWithoutLocation();

		if (!concerts.isEmpty()) {
			return new ResponseEntity<List<Concert>>(concerts, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Concert>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "concerts/pairedByMusic", method = RequestMethod.GET)
	public ResponseEntity<List<Arrays>> getConcertPairedByMusic() {
		List<Arrays> concerts = concertRepository.findConcertPairedByMusic();

		if (!concerts.isEmpty()) {
			return new ResponseEntity<List<Arrays>>(concerts, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Arrays>>(HttpStatus.NOT_FOUND);
		}
	}
	
}
