package co.edu.eafit.dis.olimpo.service;

import java.util.Optional;

import co.edu.eafit.dis.olimpo.entity.Event;

public interface EventService {
	Optional<Event> getById(String id);

	Event update(Event event);

	Event create(Event event);

	void delete(String id);
}
