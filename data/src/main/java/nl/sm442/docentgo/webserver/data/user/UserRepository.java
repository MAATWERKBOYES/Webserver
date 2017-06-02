package nl.sm442.docentgo.webserver.data.user;

import nl.sm442.docentgo.webserver.domain.User;

import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
public interface UserRepository {

    Collection<User> getAll();

    User get(String id);

    void save(User user);

    void addPerson(String userId, String personId);

    void updatePerson(String userId, String personId, int level);
}
