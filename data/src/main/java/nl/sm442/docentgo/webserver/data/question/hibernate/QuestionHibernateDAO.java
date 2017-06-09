package nl.sm442.docentgo.webserver.data.question.hibernate;

import nl.sm442.docentgo.webserver.data.dao.HibernateDAO;
import nl.sm442.docentgo.webserver.data.question.QuestionDAO;
import nl.sm442.docentgo.webserver.domain.Department;
import nl.sm442.docentgo.webserver.domain.Question;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Random;

/**
 * @author Oscar de Leeuw
 */
public class QuestionHibernateDAO extends HibernateDAO<Long, Question> implements QuestionDAO {

    private static final Random random = new Random();

    /**
     * Creates a new nl.sm442.docentgo.webserver.data.dao.HibernateDAO.
     *
     * @param entityManager The EntityManager for managing the JPA.
     */
    protected QuestionHibernateDAO(EntityManager entityManager) {
        super(entityManager, Question.class);
    }

    @Override
    public Question getQuestionForDepartment(Department department) {
        //Question.getAmountOfQuestionsForDepartment
        TypedQuery<Long> countQuery = em.createNamedQuery("Question.getAmountOfQuestionsForDepartment", Long.class);
        countQuery.setParameter("department", department);
        long amount = countQuery.getSingleResult();

        TypedQuery<Question> query = em.createNamedQuery("Question.getQuestionForDepartment", Question.class);
        query.setParameter("department", department);
        query.setMaxResults(1);
        query.setFirstResult(random.nextInt((int) amount));

        return query.getSingleResult();
    }

    @Override
    public void remove(Long id) {
        Question question = find(id);
        remove(question);
    }
}
