package co.edu.eafit.dis.olimpo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eafit.dis.olimpo.entity.Person;
import co.edu.eafit.dis.olimpo.repository.PersonRepository;

@RestController
@RequestMapping("person")
public class PersonController {
	
	@Autowired
	private PersonRepository repository;

	@RequestMapping("{id}")
	public Person getPerson(@PathVariable Long id){
		return repository.findOne(id);
	}
	
	@RequestMapping("search/{lastName}")
	public List<Person> getPerson(@PathVariable String lastName){
		return repository.findByLastNameIgnoreCase(lastName);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Person savePerson(@RequestBody Person person){
		return repository.save(person);
	}
}
