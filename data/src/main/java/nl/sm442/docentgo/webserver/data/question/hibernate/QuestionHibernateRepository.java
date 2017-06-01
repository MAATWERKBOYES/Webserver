package nl.sm442.docentgo.webserver.data.question.hibernate;

import nl.sm442.docentgo.webserver.data.question.QuestionDAO;
import nl.sm442.docentgo.webserver.data.question.QuestionRepository;
import nl.sm442.docentgo.webserver.data.repository.HibernateRepository;
import nl.sm442.docentgo.webserver.domain.Question;

import javax.persistence.EntityManager;
import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
public class QuestionHibernateRepository extends HibernateRepository<Long, Question, QuestionDAO> implements QuestionRepository {
    @Override
    protected QuestionDAO createDao(EntityManager manager) {
        return new QuestionHibernateDAO(manager);
    }

    @Override
    public Collection<Question> getAll() {
        return findAll();
    }

    @Override
    public Question get(Long id) {
        return find(id);
    }

    @Override
    public void save(Question question) {
        edit(question);
    }
}
