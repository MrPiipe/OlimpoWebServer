package co.edu.eafit.dis.olimpo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.eafit.dis.olimpo.entity.User;

public interface UserRepository extends MongoRepository<User, ObjectId>{

}
