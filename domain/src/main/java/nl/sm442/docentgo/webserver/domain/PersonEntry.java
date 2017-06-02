package nl.sm442.docentgo.webserver.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Oscar de Leeuw
 */
@Entity
@AssociationOverrides({
        @AssociationOverride(name = "fk.person",
                joinColumns = @JoinColumn(name = "PERSON_ID")),
        @AssociationOverride(name = "fk.user",
                joinColumns = @JoinColumn(name = "USER_ID"))})
public class PersonEntry {

    @EmbeddedId
    private PersonEntryFk fk = new PersonEntryFk();
    private int level;

    public PersonEntryFk getFk() {
        return fk;
    }

    public void setFk(PersonEntryFk fk) {
        this.fk = fk;
    }

    @Transient
    public Person getPerson() {
        return getFk().getPerson();
    }

    public void setPerson(Person person) {
        getFk().setPerson(person);
    }

    @Transient
    public User getUser() {
        return getFk().getUser();
    }

    public void setUser(User user) {
        getFk().setUser(user);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    @Embeddable
    public static class PersonEntryFk implements Serializable {
        @ManyToOne
        private Person person;
        @ManyToOne
        private User user;

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
}
