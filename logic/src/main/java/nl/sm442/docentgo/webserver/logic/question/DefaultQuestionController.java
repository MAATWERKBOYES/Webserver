package nl.sm442.docentgo.webserver.logic.question;

import nl.sm442.docentgo.webserver.data.question.QuestionRepository;
import nl.sm442.docentgo.webserver.data.question.hibernate.QuestionHibernateRepository;
import nl.sm442.docentgo.webserver.domain.Question;

import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
public class DefaultQuestionController implements QuestionController {

    private QuestionRepository repository;

    public DefaultQuestionController() {
        this(new QuestionHibernateRepository());
    }

    public DefaultQuestionController(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question get(Long id) {
        return repository.get(id);
    }

    @Override
    public void save(Question question) {
        repository.save(question);
    }

    @Override
    public void remove(Long id) {
        repository.remove(id);
    }
}
