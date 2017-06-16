package nl.sm442.docentgo.webserver.web.webcontroller;

import nl.sm442.docentgo.webserver.domain.PersonEntry;
import nl.sm442.docentgo.webserver.domain.RankEntry;
import nl.sm442.docentgo.webserver.domain.User;
import nl.sm442.docentgo.webserver.logic.user.DefaultUserController;
import nl.sm442.docentgo.webserver.logic.user.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Oscar de Leeuw
 */
@CrossOrigin
@Controller
public class UserWebController {

    private static Logger logger = LoggerFactory.getLogger(UserWebController.class.getName());
    private UserController controller;

    public UserWebController() {
        this.controller = new DefaultUserController();
    }

    @RequestMapping("/user")
    public @ResponseBody
    Collection<User> getAllUsers() {
        logger.info("Handling getAllUsers request.");

        return controller.getAll();
    }

    @RequestMapping("/user/ranking")
    public @ResponseBody
    Collection<RankEntry> getUserRanking() {
        logger.info("Handling ranking request");

        List<RankEntry> data = new LinkedList<>();

        Collection<User> users = controller.getAll();
        for (User user : users) {
            double ranking = 0;

            Collection<PersonEntry> people = user.getTeachers();
            for (PersonEntry person : people) {
                ranking += 9.33 * person.getLevel() * 4.76;
            }

            data.add(new RankEntry(user.getName(), ranking));
        }

        return data;
    }

    @RequestMapping("/user/{imei}")
    public @ResponseBody
    User getUser(@PathVariable String imei) {
        logger.info("Handling getUsername request with imei: {}", imei);

        return controller.get(imei);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void saveUser(@RequestBody User user) {
        logger.info("Handling saveUser request for imei: {}.", user.getImei());

        controller.save(user);
    }

    @RequestMapping(value = "/user/{imei}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addPerson(@PathVariable String imei, @RequestParam String personId) {
        logger.info("Handling addPerson request for imei: {} and personId: {}.", imei, personId);

        controller.addPerson(imei, personId);
    }
}
