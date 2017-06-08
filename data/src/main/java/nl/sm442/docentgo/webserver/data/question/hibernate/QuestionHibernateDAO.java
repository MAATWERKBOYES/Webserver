package nl.sm442.docentgo.webserver.data.question.hibernate;

import nl.sm442.docentgo.webserver.data.dao.HibernateDAO;
import nl.sm442.docentgo.webserver.data.question.QuestionDAO;
import nl.sm442.docentgo.webserver.domain.Question;

import javax.persistence.EntityManager;

/**
 * @author Oscar de Leeuw
 */
public class QuestionHibernateDAO extends HibernateDAO<Long, Question> implements QuestionDAO {
    /**
     * Creates a new nl.sm442.docentgo.webserver.data.dao.HibernateDAO.
     *
     * @param entityManager The EntityManager for managing the JPA.
     */
    protected QuestionHibernateDAO(EntityManager entityManager) {
        super(entityManager, Question.class);
    }

    @Override
    public void remove(Long id) {
        Question question = find(id);
        remove(question);
    }
}
