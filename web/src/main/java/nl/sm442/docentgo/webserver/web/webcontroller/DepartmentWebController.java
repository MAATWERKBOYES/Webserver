package nl.sm442.docentgo.webserver.web.webcontroller;

import nl.sm442.docentgo.webserver.logic.department.DefaultDepartmentController;
import nl.sm442.docentgo.webserver.logic.department.DepartmentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
@CrossOrigin
@Controller
public class DepartmentWebController {

    private static Logger logger = LoggerFactory.getLogger(DepartmentWebController.class.getName());
    private DepartmentController controller;

    public DepartmentWebController() {
        this.controller = new DefaultDepartmentController();
    }

    @RequestMapping("/department")
    public @ResponseBody
    Collection<String> getAllDepartments() {
        logger.info("Handling getAllDepartments request.");

        return controller.getAllDepartments();
    }
}
