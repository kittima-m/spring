package web.spring.school.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.spring.school.model.Contact;
import web.spring.school.service.ContactService;


@Controller
public class ContactController {

    private static Logger log = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @RequestMapping("/contact")
    public String displayContactPage() {
        return "contact.html";

    }

    @PostMapping("/saveMsg")
    public ModelAndView saveMessage(@RequestParam Contact contact){
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
