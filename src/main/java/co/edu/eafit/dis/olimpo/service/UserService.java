package co.edu.eafit.dis.olimpo.service;

import java.util.Optional;

import org.bson.types.ObjectId;

import co.edu.eafit.dis.olimpo.entity.User;

public interface UserService {
	Optional<User> getById(ObjectId id);

	User update(User user);

	User create(User user);

	void delete(ObjectId id);
}
