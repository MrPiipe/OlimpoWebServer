package co.edu.eafit.dis.olimpo.service;

import java.util.Optional;

import org.bson.types.ObjectId;

import co.edu.eafit.dis.olimpo.entity.Event;

public interface EventService {
	Optional<Event> getById(ObjectId id);

	Event update(Event event);

	Event create(Event event);

	void delete(ObjectId id);
}
