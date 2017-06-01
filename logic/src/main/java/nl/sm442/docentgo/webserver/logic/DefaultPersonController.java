package nl.sm442.docentgo.webserver.logic;

import nl.sm442.docentgo.webserver.data.person.PersonRepository;
import nl.sm442.docentgo.webserver.data.person.hibernate.PersonHibernateRepository;
import nl.sm442.docentgo.webserver.domain.Person;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    public void updatePersons(Collection<Person> newData) {
        Map<String, Person> currentData = repository.getAll()
                .stream()
                .collect(Collectors.toMap(Person::getId, Function.identity()));

        newData.forEach(p -> p.setPresent(currentData.get(p.getId()).isPresent()));
        repository.saveAll(newData);
    }
}
