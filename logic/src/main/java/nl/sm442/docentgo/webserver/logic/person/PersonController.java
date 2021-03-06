package nl.sm442.docentgo.webserver.logic.person;

import nl.sm442.docentgo.webserver.domain.Person;

import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
public interface PersonController {

    void updatePersons(Collection<Person> personCollection);

    void updatePresence(String id, boolean presence);

    Collection<Person> getAllPersons();

    Person getPersonByAbbreviation(String abbreviation);
}
