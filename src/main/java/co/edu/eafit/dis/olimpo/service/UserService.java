package co.edu.eafit.dis.olimpo.service;

import java.util.Optional;

import co.edu.eafit.dis.olimpo.entity.User;

public interface UserService {
	Optional<User> getById(String id);

	User update(User user);

	User create(User user);

	void delete(String id);
}
