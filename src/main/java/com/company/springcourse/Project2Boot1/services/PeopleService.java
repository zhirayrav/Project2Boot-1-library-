package com.company.springcourse.Project2Boot1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.springcourse.Project2Boot1.models.Person;
import com.company.springcourse.Project2Boot1.repositories.PeopleRepository;



@Service
@Transactional(readOnly = true)
public class PeopleService {
	private final PeopleRepository peopleRepository;
	
	@Autowired
	public PeopleService(PeopleRepository peopleRepository) {
		super();
		this.peopleRepository = peopleRepository;
	}

	public List<Person> findAll(){
		return peopleRepository.findAll();
	}
	public Person findOne(int id) {
		return peopleRepository.findById(id).orElse(null);
	}
	@Transactional
	public void save(Person person) {
		peopleRepository.save(person);
	}
	@Transactional
	public void deleteById(int id) {
		peopleRepository.deleteById(id);
	}
	@Transactional
	public void update(int id,Person updatedPerson) {
		updatedPerson.setId(id);
		peopleRepository.save(updatedPerson);
	}
	public Optional<Person> getPersonByName(String name) {
		return peopleRepository.findByName(name);
	}
	
	
	
	

}
