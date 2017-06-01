package nl.sm442.docentgo.webserver.data.person.hibernate;

import nl.sm442.docentgo.webserver.data.person.PersonDAO;
import nl.sm442.docentgo.webserver.data.person.PersonRepository;
import nl.sm442.docentgo.webserver.data.repository.HibernateRepository;
import nl.sm442.docentgo.webserver.domain.Person;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.function.Function;

/**
 * @author Oscar de Leeuw
 */
public class PersonHibernateRepository extends HibernateRepository<String, Person, PersonDAO> implements PersonRepository {

    @Override
    public void saveAll(Collection<Person> persons) {
        Function<PersonDAO, Void> function = dao -> {
            persons.forEach(dao::edit);
            return null;
        };

        performTransaction(function);
    }

    @Override
    protected PersonDAO createDao(EntityManager manager) {
        return new PersonHibernateDAO(manager);
    }
}
