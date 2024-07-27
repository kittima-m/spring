package web.spring.school.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.spring.school.model.Contact;
import web.spring.school.service.ContactService;

@Slf4j
@Controller
public class ContactController {

    @Autowired
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact.html";

    }

    @PostMapping("/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.error("Contact form validation failed due to :{}", errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }
}
