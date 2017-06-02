package nl.sm442.docentgo.webserver.data.user;

import nl.sm442.docentgo.webserver.data.dao.DAO;
import nl.sm442.docentgo.webserver.domain.Person;
import nl.sm442.docentgo.webserver.domain.User;

/**
 * @author Oscar de Leeuw
 */
public interface UserDAO extends DAO<String, User> {

    Person getPerson(String id);
}
