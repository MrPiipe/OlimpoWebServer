package co.edu.eafit.dis.olimpo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.eafit.dis.olimpo.entity.Event;

public interface EventRepository extends MongoRepository<Event, ObjectId>{

}
