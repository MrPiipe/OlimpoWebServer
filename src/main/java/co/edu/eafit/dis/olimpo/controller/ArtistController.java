package co.edu.eafit.dis.olimpo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eafit.dis.olimpo.entity.Artist;
import co.edu.eafit.dis.olimpo.service.ArtistService;

@RestController
public class ArtistController {

	@Autowired
	private ArtistService artistService;
	
	@RequestMapping(value = "artist", method = RequestMethod.GET )
	public List<Artist> getAllArtist() {
		return artistService.getAllArtist();
	}

	@RequestMapping(value = "artist/{id}", method = RequestMethod.GET )
	public Artist getById(@PathVariable(value = "id") String id) {
		Optional<Artist> artist = artistService.getById(new String(id));
		if (artist.isPresent()) {
			return artist.get();
		} else {
			throw new RuntimeException("el artista no existe");
		}
	}

	@RequestMapping(value = "artist", method = RequestMethod.POST)
	public Artist saveArtist(@RequestBody Artist artist) {
		return artistService.create(artist);
	}

	@RequestMapping(value = "artist/{id}", method = RequestMethod.PUT)
	public Artist updateArtist(@RequestBody Artist artist) {
		return artistService.update(artist);
	}

	@RequestMapping(value = "artist/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteArtist(@PathVariable(value = "id") String id) {
		artistService.delete(new String(id));
	}
}
