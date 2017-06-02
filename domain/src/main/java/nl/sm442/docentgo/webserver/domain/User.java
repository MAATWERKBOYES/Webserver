package nl.sm442.docentgo.webserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedQueries(
        value = @NamedQuery(name = "User.getPerson", query = "SELECT p FROM Person p WHERE p.id = :id")
)
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

    public void addPerson(Person person) {
        PersonEntry entry = new PersonEntry();
        entry.setLevel(1);
        entry.setPerson(person);
        entry.setUser(this);

        teachers.add(entry);
    }

    public void updatePerson(String id, int level) {
        teachers.stream()
                .filter(p -> p.getPerson().getId().equals(id))
                .findFirst()
                .ifPresent(p -> p.setLevel(level));
    }
}
