package pl.coderslab.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;

    public Person add(Person person) {
        entityManager.persist(person);
        return person;
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person person){
        entityManager.merge(person);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.contains(findById(id)) ?
                findById(id) : entityManager.merge(findById(id)));
    }
}
