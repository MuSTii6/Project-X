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

import ch.zhaw.springboot.entities.Piece;
import ch.zhaw.springboot.repositories.PieceRepository;

@RestController
public class PieceRestController {

    
    @Autowired
    private PieceRepository pieceRepository;

    @RequestMapping(value = "pieces", method = RequestMethod.GET)
	public ResponseEntity<List<Piece>> getPieces() {
		List<Piece> pieces = pieceRepository.findAll();

		if (!pieces.isEmpty()) {
			return new ResponseEntity<List<Piece>>(pieces, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Piece>>(HttpStatus.NOT_FOUND);
		}
	}

    @RequestMapping(value = "pieces/{id}", method = RequestMethod.GET)
	public ResponseEntity<Piece> getPieceById(@PathVariable("id") long id) {
		Optional<Piece> piece = pieceRepository.findById(id);

		if (piece.isPresent()) {
			return new ResponseEntity<Piece>(piece.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Piece>(HttpStatus.NOT_FOUND);
		}
	}
}
