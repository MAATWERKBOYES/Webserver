package nl.sm442.docentgo.webserver.web.webcontroller;

import nl.sm442.docentgo.webserver.web.token.TokenHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Oscar de Leeuw
 */
@Controller
@CrossOrigin
public class LoginWebController {

    private static Logger logger = LoggerFactory.getLogger(LoginWebController.class.getName());


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void setAccessToken(@RequestParam String token) {
        logger.info("Received setAccessToken request with token: {}", token);

        TokenHolder.getInstance().setToken(token);
    }
}
