package pl.coderslab.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public Publisher addPublisher(Publisher publisher) {
        entityManager.persist(publisher);
        return publisher;
    }

    public Publisher findPublisherById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }

//    public void delete(Publisher publisher) {
//        entityManager.remove(entityManager.contains(publisher) ?
//                publisher : entityManager.merge(publisher));
//    }

    public void delete(long id) {
        entityManager.remove(entityManager.contains(findPublisherById(id)) ?
                findPublisherById(id) : entityManager.merge(findPublisherById(id)));
    }
    public List<Publisher> findAll(){
        return entityManager.createQuery("select p from Publisher p").getResultList();
    }
}
