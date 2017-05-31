package co.edu.eafit.dis.olimpo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eafit.dis.olimpo.entity.Event;
import co.edu.eafit.dis.olimpo.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventRepository eventRepo;

	@Override
	public Optional<Event> getById(String id) {
		return eventRepo.findById(id);
	}

	@Override
	public Event update(Event event) {
		return eventRepo.save(event);
	}
	
	@Override
	public Event create(Event event) {
		return eventRepo.insert(event);
	}

	@Override
	public void delete(String id) {
		eventRepo.deleteById(id);
	}
}
