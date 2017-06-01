package nl.sm442.docentgo.webserver.data.person;

import nl.sm442.docentgo.webserver.domain.Person;

import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
public interface PersonRepository {

    void saveAll(Collection<Person> persons);
}
