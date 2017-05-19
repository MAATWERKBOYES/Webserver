package nl.sm442.docentgo.webserver.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author Oscar de Leeuw
 */
public class DocentGoHttpInterceptor implements ClientHttpRequestInterceptor {

    private final static String AUTH_CODE = "";

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().add(HttpHeaders.ACCEPT, "application/json");
        request.getHeaders().add(HttpHeaders.AUTHORIZATION, AUTH_CODE);
        return execution.execute(request, body);
    }
}
