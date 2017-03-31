package co.edu.eafit.dis.olimpo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.eafit.dis.olimpo.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findByLastNameIgnoreCase(String lastName);
}
