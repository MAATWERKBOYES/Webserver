package nl.sm442.docentgo.webserver.data.user.hibernate;

import nl.sm442.docentgo.webserver.data.repository.HibernateRepository;
import nl.sm442.docentgo.webserver.data.user.UserDAO;
import nl.sm442.docentgo.webserver.data.user.UserRepository;
import nl.sm442.docentgo.webserver.domain.Person;
import nl.sm442.docentgo.webserver.domain.PersonEntry;
import nl.sm442.docentgo.webserver.domain.User;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author Oscar de Leeuw
 */
public class UserHibernateRepository extends HibernateRepository<String, User, UserDAO> implements UserRepository {
    @Override
    protected UserDAO createDao(EntityManager manager) {
        return new UserHibernateDAO(manager);
    }

    @Override
    public Collection<User> getAll() {
        return findAll();
    }

    @Override
    public User get(String id) {
        return find(id);
    }

    @Override
    public void save(User user) {
        edit(user);
    }

    @Override
    public void addPerson(String userId, String personId) {
        Function<UserDAO, Void> function = dao -> {
            User user = dao.find(userId);
            Person person = dao.getPerson(personId);

            Optional<PersonEntry> entry = user.getTeachers()
                    .stream()
                    .filter(e -> Objects.equals(e.getPerson().getId(), personId))
                    .findFirst();

            if (entry.isPresent()) {
                PersonEntry value = entry.get();
                value.setLevel(value.getLevel() + 1);
            } else {
                user.addPerson(person);
            }

            dao.edit(user);
            return null;
        };

        performTransaction(function);
    }

    @Override
    public void updatePerson(String userId, String personId, int level) {
        Function<UserDAO, Void> function = dao -> {
            User user = dao.find(userId);
            user.updatePerson(personId, level);
            dao.edit(user);

            return null;
        };

        performTransaction(function);
    }
}
