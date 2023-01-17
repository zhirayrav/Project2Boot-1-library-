package com.company.springcourse.Project2Boot1.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.company.springcourse.Project2Boot1.models.Person;
import com.company.springcourse.Project2Boot1.services.PeopleService;


@Component
public class PersonValidator implements Validator{
	private final PeopleService peopleService;
	
	@Autowired
	public PersonValidator(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
			Person person = (Person) o;
			if(peopleService.getPersonByName(person.getName()).isPresent()) {
				errors.rejectValue("name", "", "This name is already taken");
			}
		
	}

}

