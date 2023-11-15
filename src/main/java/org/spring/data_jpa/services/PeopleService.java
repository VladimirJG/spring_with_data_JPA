package org.spring.data_jpa.services;

import org.spring.data_jpa.model.Debt;
import org.spring.data_jpa.model.Person;
import org.spring.data_jpa.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> person = peopleRepository.findById(id);
        return person.orElse(null);
    }

    @Transactional
    public void save(Person person) {
        person.setCreatedAt(new Date());
        person.setDebt(Debt.NonDebtor);
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person upPerson) {
        upPerson.setId(id);
        peopleRepository.save(upPerson);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    /*public List<Person> findByName(String name) {
        return peopleRepository.findByName(name);
    }

    public List<Person> namesOrderByAge(String name) {
        return peopleRepository.findByNameOrderByAge(name);
    }

    public List<Person> findPersonsByEmail(String email) {
        return peopleRepository.findByEmail(email);
    }

    public List<Person> findPersonsByStartingString(String startingString) {
        return peopleRepository.findByNameStartingWith(startingString);
    }

    public List<Person> findPersonsByNameOrEmail(String name, String email) {
        return peopleRepository.findByNameOrEmail(name, email);
    }*/
    public void test() {
        System.out.println("Testing here with debug. Inside Hibernate Transaction");
    }
}
