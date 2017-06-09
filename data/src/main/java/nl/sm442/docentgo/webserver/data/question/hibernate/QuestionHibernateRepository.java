package nl.sm442.docentgo.webserver.data.question.hibernate;

import nl.sm442.docentgo.webserver.data.question.QuestionDAO;
import nl.sm442.docentgo.webserver.data.question.QuestionRepository;
import nl.sm442.docentgo.webserver.data.repository.HibernateRepository;
import nl.sm442.docentgo.webserver.domain.Department;
import nl.sm442.docentgo.webserver.domain.Question;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.function.Function;

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
    public Question getQuestionForDepartment(Department department) {
        Function<QuestionDAO, Question> removeFunction = dao -> dao.getQuestionForDepartment(department);
        return super.performTransaction(removeFunction);
    }

    @Override
    public void save(Question question) {
        edit(question);
    }

    @Override
    public void remove(Long id) {
        Function<QuestionDAO, Void> removeFunction = dao -> {
            dao.remove(id);
            return null;
        };

        super.performTransaction(removeFunction);
    }
}
