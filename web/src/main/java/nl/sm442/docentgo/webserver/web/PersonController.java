package nl.sm442.docentgo.webserver.web;

import nl.sm442.docentgo.webserver.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
@Controller
@CrossOrigin
public class PersonController {

    private RestTemplate template;

    @Autowired
    public PersonController(RestTemplate template) {
        this.template = template;
    }

    @RequestMapping("/persons")
    public @ResponseBody
    Collection<Person> getPersons() {
        return Arrays.asList(template.getForObject("https://api.fhict.nl/people/search/oosterkamp", Person[].class));
    }
}
