package nl.sm442.docentgo.webserver.web.webcontroller;

import nl.sm442.docentgo.webserver.domain.Question;
import nl.sm442.docentgo.webserver.logic.question.DefaultQuestionController;
import nl.sm442.docentgo.webserver.logic.question.QuestionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
@CrossOrigin
@Controller
public class QuestionWebController {

    private static Logger logger = LoggerFactory.getLogger(LoginWebController.class.getName());
    private QuestionController controller;

    public QuestionWebController() {
        this.controller = new DefaultQuestionController();
    }

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public @ResponseBody
    Collection<Question> getAllQuestions() {
        logger.info("Handling getAllQuestions request.");
        return controller.getAll();
    }

    @RequestMapping("/question/{id}")
    public @ResponseBody
    Question getQuestion(@PathVariable Long id) {
        logger.info("Handling getQuestion request with id: {}.", id);
        return controller.get(id);
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void saveQuestion(@RequestBody Question question) {
        logger.info("Handling saveQuestion request.");
        controller.save(question);
    }

    @RequestMapping(value = "/question/{id}/remove", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void removeQuestion(@PathVariable Long id) {
        logger.info("Handling removeQuestion request with id: {}", id);
        controller.remove(id);
    }
}
