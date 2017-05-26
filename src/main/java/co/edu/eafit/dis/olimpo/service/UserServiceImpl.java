package co.edu.eafit.dis.olimpo.service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eafit.dis.olimpo.entity.User;
import co.edu.eafit.dis.olimpo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public Optional<User> getById(ObjectId id) {
		return userRepo.findById(id);
	}

	@Override
	public User update(User user) {
		return userRepo.save(user);
	}
	
	@Override
	public User create(User user) {
		return userRepo.insert(user);
	}

	@Override
	public void delete(ObjectId id) {
		userRepo.deleteById(id);
	}
}
