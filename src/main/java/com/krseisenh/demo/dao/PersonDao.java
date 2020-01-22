package com.krseisenh.demo.dao;

import com.krseisenh.demo.model.Person;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    };

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePerson(UUID id);

    int updatePerson(UUID id, Person person);

}
