package web.spring.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import web.spring.school.controller.ContactController;
import web.spring.school.model.Contact;

@Service
public class ContactService {

    private static Logger log = LoggerFactory.getLogger(ContactService.class);

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;

        log.debug(contact.toString());

        return isSaved;
    }
}
