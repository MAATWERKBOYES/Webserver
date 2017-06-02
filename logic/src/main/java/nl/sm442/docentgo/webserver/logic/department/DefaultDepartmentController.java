package nl.sm442.docentgo.webserver.logic.department;

import nl.sm442.docentgo.webserver.domain.Department;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Oscar de Leeuw
 */
public class DefaultDepartmentController implements DepartmentController {
    @Override
    public Collection<String> getAllDepartments() {
        return Arrays.stream(Department.values()).map(Department::toString).collect(Collectors.toList());
    }
}
