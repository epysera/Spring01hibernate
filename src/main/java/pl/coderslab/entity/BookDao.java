package pl.coderslab.entity;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public Book addBook(Book book) {
        entityManager.persist(book);
        return book;
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

//    public void delete(Book book) {
//        entityManager.remove(entityManager.contains(book) ?
//                book : entityManager.merge(book));
//    }


    public void delete(long id) {
        entityManager.remove(entityManager.contains(findById(id)) ?
                findById(id) : entityManager.merge(findById(id)));
    }

    public Publisher getById(Long id){
        return entityManager.find(Publisher.class, id);
    }


    public Book findBookWithAuthorsById(Long id) {
        Book book = findById(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }


    public List<Book> findAll(){
        return entityManager.createQuery("select b from Book b").getResultList();
    }

    public List<Book> findAllByRating(int rating){
        Query query = entityManager.createQuery("select b from Book b where b.rating= :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public List<Book> findBookWithPublisher() {
        return entityManager
                .createQuery("select b from Book b join b.publisher")
                .getResultList();
    }

    public List<Book> findBooksWithPublishers (Publisher publisher) {
        return entityManager
                .createQuery("select b from Book b where b.publisher = :publisher")
                .setParameter("publisher", publisher)
                .getResultList();

    }

    public List<Book> findBooksWithAuthor(Author author) {
        return entityManager
                .createQuery("SELECT distinct b FROM Book b join FETCH b.authors WHERE :author member of b.authors")
                .setParameter("author", author)
                .getResultList();
    }


}

