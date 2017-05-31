package co.edu.eafit.dis.olimpo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.eafit.dis.olimpo.entity.Artist;

public interface ArtistRepository extends MongoRepository<Artist, String>{

}
