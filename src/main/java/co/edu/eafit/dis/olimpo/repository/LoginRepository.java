package co.edu.eafit.dis.olimpo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.eafit.dis.olimpo.entity.LoginInformation;

public interface LoginRepository extends MongoRepository<LoginInformation, String>{
	
	LoginInformation findByEmailAndPassword(String email, String password);
	
	long countByEmail(String email);
}
