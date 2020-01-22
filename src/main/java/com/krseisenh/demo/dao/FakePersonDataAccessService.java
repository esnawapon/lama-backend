package com.krseisenh.demo.dao;

import com.krseisenh.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> personList = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personList.add(new Person(id, person.getFirstName(), person.getLastName()));
        return 1;
    }

    public List<Person> selectAllPeople() {
        return personList;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return personList.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        personList.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person updatePerson) {
        return selectPersonById(id).map(person -> {
            int indexOfPersonToUpdate = personList.indexOf(person);
            if (indexOfPersonToUpdate >= 0) {
                personList.set(indexOfPersonToUpdate,
                        new Person(id, updatePerson.getFirstName(), updatePerson.getLastName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}