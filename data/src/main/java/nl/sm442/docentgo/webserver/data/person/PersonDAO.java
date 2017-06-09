package nl.sm442.docentgo.webserver.data.person;

import nl.sm442.docentgo.webserver.data.dao.DAO;
import nl.sm442.docentgo.webserver.domain.Person;

/**
 * @author Oscar de Leeuw
 */
public interface PersonDAO extends DAO<String, Person> {

    Person findByAbbreviation(String abbreviation);

}
