package pl.coderslab.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookFormController {

    @Autowired
    BookDao bookDao;
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    AuthorDao authorDao;

    @RequestMapping("/add-book")
    public String showBookForm(Model model){
        model.addAttribute("book", new Book());
        return "add-book-form";
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    @ResponseBody
    public String saveBookForm(Book book){

        bookDao.addBook(book);

        return "Book was added "+book.getId();
    }
//    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
//    public String saveBookForm(Book book, Model model){
//        bookDao.addBook(book);
//        model.addAttribute("books", bookDao.findAll());
//
//        return "books-list";
//    }

    @RequestMapping(value = "/list-book")
    public String listBooks(Model model){
        model.addAttribute("books", bookDao.findAll());
        return "books-list";
    }
// nie robi update
    @RequestMapping(value = "/update-book/{id}", method = RequestMethod.GET)
    public String updateBook(@PathVariable Long id, Model model){
        model.addAttribute("book", bookDao.findById(id));
        return "updateBook";
    }

    @RequestMapping(value = "/update-book/{id}", method = RequestMethod.POST)
    public String updateBookForm(@PathVariable Long id, Book book){
        bookDao.update(book);
        return "redirect:/books-list";
    }

    @RequestMapping(value = "/book/saftydelete/{id}")
    public String safetyDelete(@PathVariable Long id, Model model){
        model.addAttribute("id", id);
        return "safetydeletebook";

    }

    @RequestMapping("/book/saftydelete/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookDao.delete(id);
        return "redirect:/books-list";
    }




    @ModelAttribute("publishers")
    public List<Publisher> getPublishers(){
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAllAuthors(){
        return authorDao.findAll();
    }

}