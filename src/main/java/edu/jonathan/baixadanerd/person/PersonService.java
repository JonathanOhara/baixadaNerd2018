package edu.jonathan.baixadanerd.person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersons(){
        return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    public Person insertPerson(Person person){
        entityManager.persist(person);
        return person;
    }

    public Person getPersonBy(Long id) {
        return entityManager.find(Person.class, id);
    }
}
