package nl.sm442.docentgo.webserver.logic.question;

import nl.sm442.docentgo.webserver.domain.Question;

import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
public interface QuestionController {

    Collection<Question> getAll();

    Question get(Long id);

    void save(Question question);
}