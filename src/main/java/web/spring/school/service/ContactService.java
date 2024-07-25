package web.spring.school.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import web.spring.school.controller.ContactController;
import web.spring.school.model.Contact;

@Slf4j
@Service
public class ContactService {

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;

        log.debug(contact.toString());

        return isSaved;
    }
}
