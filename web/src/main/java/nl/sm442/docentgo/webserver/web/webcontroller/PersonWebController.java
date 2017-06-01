package nl.sm442.docentgo.webserver.web.webcontroller;

import nl.sm442.docentgo.webserver.domain.Person;
import nl.sm442.docentgo.webserver.logic.DefaultPersonController;
import nl.sm442.docentgo.webserver.logic.PersonController;
import nl.sm442.docentgo.webserver.web.token.TokenHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Oscar de Leeuw
 */
@Controller
@CrossOrigin
public class PersonWebController {

    private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PersonWebController.class.getName());
    private RestTemplate template;

    private PersonController controller;

    @Autowired
    public PersonWebController(RestTemplate template) {
        this.template = template;
        this.controller = new DefaultPersonController();
    }

    @RequestMapping("/people")
    public @ResponseBody
    Collection<Person> getPersons() {
        logger.info("Handling getPersons request.");

        return controller.getAllPersons();
    }

    @RequestMapping("/people/me")
    public Person getMe() {
        logger.info("Handling getMe request");

        try {
            return template.getForObject("https://api.fhict.nl/people/me", Person.class);
        } catch (HttpClientErrorException e) {
            logger.warn("Response body: {}", e.getResponseBodyAsString());
            logger.warn("Headers: {}", e.getResponseHeaders());
            throw e;
        }

    }

    @RequestMapping(value = "/people/{id}/presence", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void setPresence(@PathVariable String id, @RequestParam boolean value) {
        logger.info("Handling setPresence request for {}", id);

        controller.updatePresence(id, value);
    }

    @RequestMapping("/people/save")
    @ResponseStatus(HttpStatus.OK)
    public void saveTeachersToDatabase() {
        Long start = System.currentTimeMillis();
        logger.info("Handling saveTeachersToDatabase request.");

        try {
            Long apiFetchStart = System.currentTimeMillis();
            List<Person> persons = Arrays.asList(template.getForObject("https://api.fhict.nl/people", Person[].class));
            Long apiFetchEnd = System.currentTimeMillis();
            Long dataSaveStart = System.currentTimeMillis();
            controller.updatePersons(persons);
            Long dataSaveEnd = System.currentTimeMillis();

            logger.info("Api time: {} ms", apiFetchEnd - apiFetchStart);
            logger.info("Database time: {} ms", dataSaveEnd - dataSaveStart);
        } catch (HttpClientErrorException e) {
            logger.warn("Invalid token: {}", TokenHolder.getInstance().getToken(), e);
            throw e;
        }
        Long end = System.currentTimeMillis();

        logger.info("Total request time: {} ms", end - start);
    }
}
