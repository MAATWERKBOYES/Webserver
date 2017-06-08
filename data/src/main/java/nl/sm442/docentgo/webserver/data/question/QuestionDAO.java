package nl.sm442.docentgo.webserver.data.question;

import nl.sm442.docentgo.webserver.data.dao.DAO;
import nl.sm442.docentgo.webserver.domain.Question;

/**
 * @author Oscar de Leeuw
 */
public interface QuestionDAO extends DAO<Long, Question> {

    void remove(Long id);

}
