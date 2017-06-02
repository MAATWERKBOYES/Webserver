package nl.sm442.docentgo.webserver.data.user.hibernate;

import nl.sm442.docentgo.webserver.data.dao.HibernateDAO;
import nl.sm442.docentgo.webserver.data.user.UserDAO;
import nl.sm442.docentgo.webserver.domain.Person;
import nl.sm442.docentgo.webserver.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * @author Oscar de Leeuw
 */
public class UserHibernateDAO extends HibernateDAO<String, User> implements UserDAO {
    /**
     * Creates a new nl.sm442.docentgo.webserver.data.dao.HibernateDAO.
     *
     * @param entityManager The EntityManager for managing the JPA.
     */
    protected UserHibernateDAO(EntityManager entityManager) {
        super(entityManager, User.class);
    }

    @Override
    public Person getPerson(String id) {
        TypedQuery<Person> query = em.createNamedQuery("User.getPerson", Person.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
