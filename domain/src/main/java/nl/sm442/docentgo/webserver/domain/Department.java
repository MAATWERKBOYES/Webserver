package nl.sm442.docentgo.webserver.domain;

import java.util.Arrays;

/**
 * @author Oscar de Leeuw
 */
public enum Department {
    SOFTWARE("Team S"), MEDIA("Team M"), TECHNOLOGY("Team T"), BUSINESS("Team B");

    private String value;

    Department(String value) {
        this.value = value;
    }

    public static Department fromString(String string) {
        return Arrays.stream(values()).filter(v -> v.value.equals(string)).findAny().orElseThrow(IllegalArgumentException::new);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
