package co.edu.eafit.dis.olimpo.service;

import java.util.List;
import java.util.Optional;

import co.edu.eafit.dis.olimpo.entity.Artwork;

public interface ArtworkService {

	Optional<Artwork> getById(String id);

	Artwork update(Artwork artwork);

	Artwork create(Artwork artwork);

	void delete(String id);

	List<Artwork> getAllArtwork();
}
