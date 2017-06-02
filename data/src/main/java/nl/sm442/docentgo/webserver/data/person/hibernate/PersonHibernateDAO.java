package nl.sm442.docentgo.webserver.data.person.hibernate;

import nl.sm442.docentgo.webserver.data.dao.HibernateDAO;
import nl.sm442.docentgo.webserver.data.person.PersonDAO;
import nl.sm442.docentgo.webserver.domain.Person;

import javax.persistence.EntityManager;

/**
 * @author Oscar de Leeuw
 */
public class PersonHibernateDAO extends HibernateDAO<String, Person> implements PersonDAO {
    /**
     * Creates a new nl.sm442.docentgo.webserver.data.dao.HibernateDAO.
     *
     * @param entityManager The EntityManager for managing the JPA.
     */
    public PersonHibernateDAO(EntityManager entityManager) {
        super(entityManager, Person.class);
    }

}
