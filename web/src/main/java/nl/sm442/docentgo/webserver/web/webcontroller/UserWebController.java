package nl.sm442.docentgo.webserver.web.webcontroller;

import nl.sm442.docentgo.webserver.domain.User;
import nl.sm442.docentgo.webserver.logic.user.DefaultUserController;
import nl.sm442.docentgo.webserver.logic.user.UserController;
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

    @RequestMapping("/user/{imei}")
    public @ResponseBody
    User getUser(@PathVariable String imei) {
        logger.info("Handling getUser request with imei: {}", imei);

        return controller.get(imei);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void saveUser(User user) {
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
