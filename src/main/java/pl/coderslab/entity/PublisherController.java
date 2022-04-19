package pl.coderslab.entity;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublisherController {
    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/publisher/add")
    @ResponseBody
    public String hello() {
        Publisher publisher= new Publisher();
        publisher.setName("publisher1");
        publisherDao.addPublisher(publisher);
        return "Publisher: "+publisher.getId() +" " + publisher.getName();
    }
    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findPublisherById(id);
        return publisher.toString();
    }

    @RequestMapping("/publisher/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String name ) {
        Publisher publisher = publisherDao.findPublisherById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }

//    @RequestMapping("/publisher/delete/{id}")
//    @ResponseBody
//    public String deletePublisher(@PathVariable long id) {
//        Publisher publisher = publisherDao.findPublisherById(id);
//        publisherDao.delete(publisher);
//        return "publisher deleted";
//    }

    @RequestMapping("/getallpublishers")
    @ResponseBody
    public String getAllPublishers() {
        List<Publisher> all = publisherDao.findAll();
        all.forEach(publisher -> System.out.println(publisher.getName()));
        return "publishers list";

    }
    @ModelAttribute("publishers")
    public List<Publisher> getAllAuthors(){
        return publisherDao.findAll();
    }


    @RequestMapping("/list-publisher")
    public String showAllPublishers(Model model) {
//        model.addAttribute("publishers", publisherDao.findAll());
        return "publisherlist";
    }

    @RequestMapping(value = "/add-publisher", method = RequestMethod.GET)
    public String showPublisherForm(Model model){
        model.addAttribute("publisher", new Publisher());
        return "addpublisherform";
    }

    @RequestMapping(value = "/add-publisher", method = RequestMethod.POST)
    public String saveAuthorForm(Publisher publisher, Model model){
        publisherDao.addPublisher(publisher);

        return "redirect:/list-publisher";
    }

    @RequestMapping(value = "/publisher/saftydelete/{id}")
    public String safetyPublisherDelete(@PathVariable Long id, Model model){
        model.addAttribute("publisherid", id);
        return "safetydeletepublisher";

    }

    @RequestMapping("/publisher/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherDao.delete(id);
        return "redirect:/list-publisher";
    }

    @RequestMapping(value = "/update-publisher/{id}", method = RequestMethod.GET)
    public String updatePublisher(@PathVariable Long id, Model model){
        model.addAttribute("publisher", publisherDao.findPublisherById(id));
        return "updatepublisher";
    }

    @RequestMapping(value = "/update-publisher/{id}", method = RequestMethod.POST)
    public String updatePublisherForm(@PathVariable Long id, Publisher publisher){
        publisherDao.update(publisher);
        return "redirect:/list-publisher";
    }

}
