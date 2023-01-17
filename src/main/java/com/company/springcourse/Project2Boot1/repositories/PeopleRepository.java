package com.company.springcourse.Project2Boot1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.springcourse.Project2Boot1.models.Person;



@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer>{
	Optional<Person> findByName(String name);
}
