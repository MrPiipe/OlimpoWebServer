package co.edu.eafit.dis.olimpo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.eafit.dis.olimpo.entity.Artwork;

public interface ArtworkRepository extends MongoRepository<Artwork, String>{

}