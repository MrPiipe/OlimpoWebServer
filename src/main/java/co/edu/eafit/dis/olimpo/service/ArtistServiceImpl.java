package co.edu.eafit.dis.olimpo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eafit.dis.olimpo.entity.Artist;
import co.edu.eafit.dis.olimpo.repository.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService{
	
	@Autowired
	private ArtistRepository artistRepo;

	@Override
	public Optional<Artist> getById(ObjectId id) {
		return artistRepo.findById(id);
	}

	@Override
	public Artist update(Artist artist) {
		return artistRepo.save(artist);
	}
	
	@Override
	public Artist create(Artist artist) {
		return artistRepo.insert(artist);
	}

	@Override
	public void delete(ObjectId id) {
		artistRepo.deleteById(id);
	}

	@Override
	public List<Artist> getAllArtist() {
		return artistRepo.findAll();
	}

}
