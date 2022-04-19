package pl.coderslab.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private PublisherDao publisherDao;
    @Autowired
    private AuthorDao authorDao;

//    private final BookDao bookDao;
//
//    public BookController(BookDao bookDao) {
//        this.bookDao = bookDao;
//    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String hello() {
        Author author1 = authorDao.findAuthorById(2);
        Author author2 = authorDao.findAuthorById(4);

        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setTitle("pan tadek");
        book.setRating(5);
        book.setDescription("opis");
        book.setPublisher(publisher);
        bookDao.addBook(book);
        return "Id dodanej książki to:"
                + book.getId();
    }

    @RequestMapping("/add2")
    @ResponseBody

    public String addBook2(){
        Publisher publisher = publisherDao.findPublisherById(1);
        Book book = new Book();
        book.setRating(1);
        book.setTitle("Pan Wołodyjowski");
        book.setDescription("Opis");
        book.setPublisher(publisher);
        bookDao.addBook(book);
        return "done";

    }
    @RequestMapping("/get")
    @ResponseBody
    public String getBook(){
        Book book = bookDao.findById(1);
        Publisher publisher = book.getPublisher();
        return publisher.getName();

    }

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

//    @RequestMapping("/book/delete/{id}")
//    @ResponseBody
//    public String deleteBook(@PathVariable long id) {
//        Book book = bookDao.findById(id);
////        bookDao.delete(book);
//        return "book deleted";
//    }

    @RequestMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookDao.delete(id);
        return "redirect:/list-book";
    }
// zad1
    @RequestMapping("/getall")
    @ResponseBody
    public String getAllBooks() {
        List<Book> all = bookDao.findAll();
        all.forEach(book -> System.out.println(book.getTitle()));
        return "book list";

    }

    @RequestMapping("/get2")
    @ResponseBody
    public String getBookByRating() {
        List<Book> all = bookDao.findAllByRating(6);
        all.forEach(book -> System.out.println(book.getTitle()));
        return "book list by rating";
//zad2
    }
    @RequestMapping("/book/findall/{rating}")
    @ResponseBody
    public String findAllByRating(@PathVariable Integer rating) {
        List <Book> all = bookDao.findAllByRating(rating);
        all.forEach(book -> System.out.println(book.getTitle()));
        return "book list by rating";
    }
//zad4
    //Uzupełnij klasę BookDao o metodę do pobierania listy wszystkich książek, które mają jakiegokolwiek wydawcę.

    @RequestMapping("/get3")
    @ResponseBody
    public String findAllWithPublisher() {
        List<Book> all = bookDao.findBookWithPublisher();
        all.forEach(book -> System.out.println(book.getTitle()));
        return "book list with publisher";
    }
//Uzupełnij klasę BookDao o metodę do pobierania listy wszystkich książek, które mają określonego w parametrze wydawcę.

    @RequestMapping("/book/findallbypublisher/{id}")
    @ResponseBody
    public String findAllByPublisher(@PathVariable String id) {

        List<Book> all = bookDao.findBooksWithPublishers(publisherDao.findPublisherById(Long.parseLong(id)));
        all.forEach(book -> System.out.println(book.getTitle()));
        return "book list with publisher" + publisherDao.findPublisherById(Long.parseLong(id));
    }
//Uzupełnij klasę BookDao o metodę do pobierania listy wszystkich książek, które mają określonego w parametrze autora.

    @RequestMapping("/book/findallbyauthor/{id}")
    @ResponseBody
    public String findAllByAuthor(@PathVariable String id) {

        List<Book> all = bookDao.findBooksWithAuthor(authorDao.findAuthorById(Long.parseLong(id)));
        all.forEach(book -> System.out.println(book.getTitle()));
        return "book list with author" + authorDao.findAuthorById(Long.parseLong(id));
    }

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("books", bookDao.findAll());

        return "books-list";
    }
}
