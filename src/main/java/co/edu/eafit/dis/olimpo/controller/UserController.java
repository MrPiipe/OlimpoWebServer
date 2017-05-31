package co.edu.eafit.dis.olimpo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eafit.dis.olimpo.entity.User;
import co.edu.eafit.dis.olimpo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "currentUser", method = RequestMethod.GET )
	public User getCurrentUser() {
		return null;
	}

	@RequestMapping(value = "user/{id}", method = RequestMethod.GET )
	public User getById(@PathVariable(value = "id") String id) {
		Optional<User> user = userService.getById(new String(id));
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new RuntimeException("No se encontro el usuario");
		}
	}

	@PreAuthorize("hasAuthority('USER')")
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		return userService.create(user);
	}

	@PreAuthorize("hasAuthority('USER')")
	@RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		return userService.update(user);
	}

	@RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable(value = "id") String id) {
		userService.delete(new String(id));
	}
}
