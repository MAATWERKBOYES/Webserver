package nl.sm442.docentgo.webserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Oscar de Leeuw
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Answer {

    @Id
    @GeneratedValue
    private Long id;
    private String value;

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
}
