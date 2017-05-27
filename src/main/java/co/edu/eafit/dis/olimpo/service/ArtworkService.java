package co.edu.eafit.dis.olimpo.service;

import java.util.Optional;

import org.bson.types.ObjectId;

import co.edu.eafit.dis.olimpo.entity.Artwork;

public interface ArtworkService {

	Optional<Artwork> getById(ObjectId id);

	Artwork update(Artwork artwork);

	Artwork create(Artwork artwork);

	void delete(ObjectId id);
}
