package co.edu.eafit.dis.olimpo.controller;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eafit.dis.olimpo.entity.Event;
import co.edu.eafit.dis.olimpo.service.EventService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;

	@RequestMapping(value = "event/{id}", method = RequestMethod.GET )
	public Event getById(@PathVariable(value = "id") String id) {
		Optional<Event> event = eventService.getById(new ObjectId(id));
		if (event.isPresent()) {
			return event.get();
		} else {
			throw new RuntimeException("El evento no existe");
		}
	}

	@RequestMapping(value = "event", method = RequestMethod.POST)
	public Event saveEvent(@RequestBody Event event) {
		//TODO Manage Artwork and Artist lists on create, possibly from FrontEnd
		return eventService.create(event);
	}

	@RequestMapping(value = "event/{id}", method = RequestMethod.PUT)
	public Event updateEvent(@RequestBody Event event) {
		return eventService.update(event);
	}

	@RequestMapping(value = "event/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteEvent(@PathVariable(value = "id") String id) {
		eventService.delete(new ObjectId(id));
	}
}
