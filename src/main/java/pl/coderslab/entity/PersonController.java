package pl.coderslab.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @Autowired
    PersonDao personDao;

    @RequestMapping("/add")
    @ResponseBody
    public String addBook() {
        Person person = personService.addPersonByDetails("Imie", "Nazwisko", "Miasto", "Ulica", 12, "login", "hasło", "email");
        String result = "Id dodanej osoby to:"+person.getId();
        return result;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showPersonForm(Model model){

        Person person = new Person();
        model.addAttribute("person", person);

        return "personForm";
    }

    //zadanie 1
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String showPersonFormZad1(@RequestParam String email, @RequestParam String password, @RequestParam String login){

        Person person = new Person();
        person.setEmail(email);
        person.setLogin(login);
        person.setPassword(password);

        personDao.add(person);

        return "thankYou";
    }

    //zadanie 2
    @RequestMapping(value = "/zad2", method = RequestMethod.POST)
    public String showPersonForm(Person person){ //tu dostajemy obiekt zbindowany (wypelniony danymi)

        personDao.add(person);

        return "thankYou";
    }

}
