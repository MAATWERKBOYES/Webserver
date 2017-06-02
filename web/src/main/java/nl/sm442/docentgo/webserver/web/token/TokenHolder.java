package nl.sm442.docentgo.webserver.web.token;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Oscar de Leeuw
 */
public class TokenHolder {

    private static TokenHolder instance;
    private Collection<String> tokens;
    private String token;

    public TokenHolder() {
        tokens = new LinkedList<>();
    }

    public static TokenHolder getInstance() {
        if (instance == null) {
            instance = new TokenHolder();
        }

        return instance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
