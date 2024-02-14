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

import ch.zhaw.springboot.entities.Music;
import ch.zhaw.springboot.repositories.MusicRepository;

@RestController
public class MusicRestController {

   
    @Autowired
    private MusicRepository musicRepository;

    @RequestMapping(value = "musics", method = RequestMethod.GET)
	public ResponseEntity<List<Music>> getMusics() {
		List<Music> musics = this.musicRepository.findAll();

		if (!musics.isEmpty()) {
			return new ResponseEntity<List<Music>>(musics, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Music>>(HttpStatus.NOT_FOUND);
		}
	}

    @RequestMapping(value = "musics/{id}", method = RequestMethod.GET)
	public ResponseEntity<Music> getMusicById(@PathVariable("id") long id) {
		Optional<Music> music = musicRepository.findById(id);

		if (music.isPresent()) {
			return new ResponseEntity<Music>(music.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Music>(HttpStatus.NOT_FOUND);
		}
	}
}
