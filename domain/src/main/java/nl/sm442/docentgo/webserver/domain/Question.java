package nl.sm442.docentgo.webserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
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
    private String value;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "jnd_ques_ans", joinColumns = @JoinColumn(name = "ques_id"), inverseJoinColumns = @JoinColumn(name = "ans_id"))
    private Collection<Answer> answers;
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<Answer> answers) {
        this.answers = answers;
    }

    public String getDepartment() {
        return department.toString();
    }

    public void setDepartment(String department) {
        this.department = Department.fromString(department);
    }
}
