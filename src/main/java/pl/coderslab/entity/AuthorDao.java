package pl.coderslab.entity;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public Author addAuthor (Author author) {
        entityManager.persist(author);
        return author;
    }

    public Author findAuthorById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

//    public void delete(Author author) {
//        entityManager.remove(entityManager.contains(author) ?
//                author : entityManager.merge(author));
//    }
public void delete(long id) {
    entityManager.remove(entityManager.contains(findAuthorById(id)) ?
            findAuthorById(id) : entityManager.merge(findAuthorById(id)));
}



    public List<Author> findAll(){
        return entityManager.createQuery("select a from Author a").getResultList();
    }
}
