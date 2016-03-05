package com.jasondyjohnson.repository;

import com.jasondyjohnson.domain.Person;
import com.jasondyjohnson.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Jason on 2/20/2016.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLoginName(String loginName);
    Person findById(Long id);
}
