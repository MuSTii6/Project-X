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

import ch.zhaw.springboot.entities.Composition;
import ch.zhaw.springboot.repositories.CompositionRepository;

@RestController

public class CompositionRestController {

   
    @Autowired
    private CompositionRepository compositionRepository;

    @RequestMapping(value = "compositions", method = RequestMethod.GET)
	public ResponseEntity<List<Composition>> getCompositions() {
		List<Composition> compositions = compositionRepository.findAll();

		if (!compositions.isEmpty()) {
			return new ResponseEntity<List<Composition>>(compositions, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Composition>>(HttpStatus.NOT_FOUND);
		}
	}

    @RequestMapping(value = "compositions/{id}", method = RequestMethod.GET)
	public ResponseEntity<Composition> getCompositionById(@PathVariable("id") long id) {
		Optional<Composition> composition = compositionRepository.findById(id);

		if (composition.isPresent()) {
			return new ResponseEntity<Composition>(composition.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Composition>(HttpStatus.NOT_FOUND);
		}
	}
}
