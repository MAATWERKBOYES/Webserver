package nl.sm442.docentgo.webserver.logic.user;

import nl.sm442.docentgo.webserver.data.user.UserRepository;
import nl.sm442.docentgo.webserver.data.user.hibernate.UserHibernateRepository;
import nl.sm442.docentgo.webserver.domain.User;

import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
public class DefaultUserController implements UserController {

    private UserRepository repository;

    public DefaultUserController() {
        this(new UserHibernateRepository());
    }

    public DefaultUserController(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User get(String imei) {
        return repository.get(imei);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void addPerson(String imei, String personId) {
        repository.addPerson(imei, personId);
    }

}
