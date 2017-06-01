package nl.sm442.docentgo.webserver.logic;

import nl.sm442.docentgo.webserver.data.person.PersonRepository;
import nl.sm442.docentgo.webserver.data.person.hibernate.PersonHibernateRepository;
import nl.sm442.docentgo.webserver.domain.Person;

import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
public class DefaultPersonController implements PersonController {

    private PersonRepository repository;

    public DefaultPersonController() {
        this(new PersonHibernateRepository());
    }

    public DefaultPersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void updatePersons(Collection<Person> personCollection) {
        repository.saveAll(personCollection);
    }
}
