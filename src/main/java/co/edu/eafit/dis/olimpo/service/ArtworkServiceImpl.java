package co.edu.eafit.dis.olimpo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eafit.dis.olimpo.entity.Artwork;
import co.edu.eafit.dis.olimpo.repository.ArtworkRepository;

@Service
public class ArtworkServiceImpl implements ArtworkService {
	
	@Autowired
	private ArtworkRepository artworkRepo;

	@Override
	public Optional<Artwork> getById(String id) {
		return artworkRepo.findById(id);
	}

	@Override
	public Artwork update(Artwork artwork) {
		return artworkRepo.save(artwork);
	}
	
	@Override
	public Artwork create(Artwork artwork) {
		return artworkRepo.insert(artwork);
	}

	@Override
	public void delete(String id) {
		artworkRepo.deleteById(id);
	}
	
	@Override
	public List<Artwork> getAllArtwork() {
		return artworkRepo.findAll();
	}

}

