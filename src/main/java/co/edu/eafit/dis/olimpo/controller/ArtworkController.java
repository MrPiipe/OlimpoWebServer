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

import co.edu.eafit.dis.olimpo.entity.Artwork;
import co.edu.eafit.dis.olimpo.service.ArtworkService;

@RestController
public class ArtworkController {

	@Autowired
	private ArtworkService artworkService;

	@RequestMapping(value = "artwork", method = RequestMethod.GET )
	public List<Artwork> getAllArtwork() {
		return artworkService.getAllArtwork();
	}
	
	@RequestMapping(value = "artwork/{id}", method = RequestMethod.GET )
	public Artwork getById(@PathVariable(value = "id") String id) {
		Optional<Artwork> artwork = artworkService.getById(new String(id));
		if (artwork.isPresent()) {
			return artwork.get();
		} else {
			throw new RuntimeException("La obra no existe");
		}
	}

	@RequestMapping(value = "artwork", method = RequestMethod.POST)
	public Artwork saveArtwork(@RequestBody Artwork artwork) { // TODO Set ID
		return artworkService.create(artwork);
	}

	@RequestMapping(value = "artwork/{id}", method = RequestMethod.PUT)
	public Artwork updateArtwork(@RequestBody Artwork artwork) {
		return artworkService.update(artwork);
	}

	@RequestMapping(value = "artwork/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteArtwork(@PathVariable(value = "id") String id) {
		artworkService.delete(new String(id));
	}
}
