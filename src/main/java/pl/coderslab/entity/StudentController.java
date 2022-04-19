package pl.coderslab.entity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showStudentForm(Model model){

        Student student = new Student();
        model.addAttribute("student", student);

        return "studentForm";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String showPersonForm(Student student){ //tu dostajemy obiekt zbindowany (wypelniony danymi)

        System.out.println(student.getCountry());

        return student.toString();
    }


    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java","Hibernate", "Spring", "Python", "C++");

    }

    @ModelAttribute("countries")
    public List<String> countries () {
        return Arrays.asList("Poland", "Germany", "France", "Denmark");

    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Biking", "Programming", "Swimming", "Runnning", "Basketball", "Football");
    }

}
