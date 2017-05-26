package co.edu.eafit.dis.olimpo.service;

import java.util.Optional;

import org.bson.types.ObjectId;

import co.edu.eafit.dis.olimpo.entity.Artist;

public interface ArtistService {

	Optional<Artist> getById(ObjectId id);

	Artist update(Artist artist);

	Artist create(Artist artist);

	void delete(ObjectId id);
}
