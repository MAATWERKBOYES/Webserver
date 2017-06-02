package nl.sm442.docentgo.webserver.logic.user;

import nl.sm442.docentgo.webserver.domain.User;

import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
public interface UserController {

    Collection<User> getAll();

    User get(String imei);

    void save(User user);

    void addPerson(String imei, String personId);
}
