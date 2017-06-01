package nl.sm442.docentgo.webserver.logic.person;

import nl.sm442.docentgo.webserver.data.person.PersonRepository;
import nl.sm442.docentgo.webserver.data.person.hibernate.PersonHibernateRepository;
import nl.sm442.docentgo.webserver.domain.Person;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
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

        newData.forEach(p ->
                Optional.ofNullable(currentData.get(p.getId()))
                        .ifPresent(a -> p.setPresent(a.isPresent())));

        repository.saveAll(newData);
    }

    @Override
    public void updatePresence(String id, boolean presence) {
        repository.updatePresence(id, presence);
    }

    @Override
    public Collection<Person> getAllPersons() {
        return repository.getAll();
    }
}
