package pl.coderslab.entity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/author/add")
    @ResponseBody
    public String addAuthor() {
        Author author = new Author();
        author.setFirstName("firstname1");
        author.setLastName("lastName2");
        authorDao.addAuthor(author);
        return "Autor: "+author.getId() +" " + author.getFirstName() + " " + author.getLastName();
    }
    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDao.findAuthorById(id);
        return author.toString();
    }

    @RequestMapping("/author/update/{id}/{firstName}/{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName, @PathVariable String lastName ) {
        Author author = authorDao.findAuthorById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.update(author);
        return author.toString();
    }

//    @RequestMapping("/author/delete/{id}")
//    @ResponseBody
//    public String deleteAuthor(@PathVariable long id) {
//        Author author = authorDao.findAuthorById(id);
//        authorDao.delete(author);
//        return "author deleted";
//    }
@RequestMapping("/author/findall")
@ResponseBody
public String findAll() {
    List<Author> all = authorDao.findAll();
    all.forEach(author -> System.out.println(author.getFirstName()));
    return "autor list";
}

    @ModelAttribute("authors")
    public List<Author> getAllAuthors(){
        return authorDao.findAll();
    }

    @RequestMapping("/list-author")
    public String showAll(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "authorlist";
    }

    @RequestMapping(value = "/add-author", method = RequestMethod.GET)
    public String showAuthorForm(Model model){
        model.addAttribute("author", new Author());
        return "addauthorform";
    }

    @RequestMapping(value = "/add-author", method = RequestMethod.POST)
    public String saveAuthorForm(Author author, Model model){
        authorDao.addAuthor(author);

        return "redirect:/list-author";
    }

    @RequestMapping(value = "/update-author/{id}", method = RequestMethod.GET)
    public String updateAuthor(@PathVariable Long id, Model model){
        model.addAttribute("author", authorDao.findAuthorById(id));
        return "updateauthor";
    }

    @RequestMapping(value = "/update-author/{id}", method = RequestMethod.POST)
    public String updateAuthorForm(@PathVariable Long id, Author author){
        authorDao.update(author);
        return "redirect:/list-author";
    }

    @RequestMapping(value = "/author/saftydelete/{id}")
    public String safetyAuthorDelete(@PathVariable Long id, Model model){
        model.addAttribute("authorid", id);
        return "safetydeleteauthor";

    }

    @RequestMapping("/author/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorDao.delete(id);
        return "redirect:/list-author";
    }
}

