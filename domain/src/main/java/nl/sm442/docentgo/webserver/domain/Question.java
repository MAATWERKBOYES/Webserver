package nl.sm442.docentgo.webserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    private Collection<Answer> answers;
    private String department; //TODO MAKE ENUM

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<Answer> answers) {
        this.answers = answers;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
