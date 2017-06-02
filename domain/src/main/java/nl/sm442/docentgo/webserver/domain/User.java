package nl.sm442.docentgo.webserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    @Id
    private String imei;
    @OneToMany(mappedBy = "fk.user")
    private Collection<PersonEntry> teachers;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Collection<PersonEntry> getTeachers() {
        return teachers;
    }

    public void setTeachers(Collection<PersonEntry> teachers) {
        this.teachers = teachers;
    }
}
