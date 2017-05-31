package co.edu.eafit.dis.olimpo.service;

import java.util.List;
import java.util.Optional;

import co.edu.eafit.dis.olimpo.entity.Artist;

public interface ArtistService {
	
	List<Artist> getAllArtist();

	Optional<Artist> getById(String id);

	Artist update(Artist artist);

	Artist create(Artist artist);

	void delete(String id);
}
