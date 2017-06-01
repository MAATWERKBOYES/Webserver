package nl.sm442.docentgo.webserver.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Oscar de Leeuw
 */
@Controller
@CrossOrigin
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class.getName());


    @RequestMapping("/login")
    public String setAccessToken(@RequestParam String token) {
        logger.info("Received setAccessToken request with token: {}", token);

        TokenHolder.getInstance().setToken(token);
        return "Bueno";
    }
}
