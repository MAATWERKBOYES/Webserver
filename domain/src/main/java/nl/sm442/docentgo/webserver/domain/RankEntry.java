package nl.sm442.docentgo.webserver.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public class RankEntry {

    private final String username;
    private final double value;

    @JsonCreator
    public RankEntry(String username, double value) {
        this.username = username;
        this.value = value;
    }

    public String getUsername() {
        return username;
    }

    public double getValue() {
        return value;
    }

}
