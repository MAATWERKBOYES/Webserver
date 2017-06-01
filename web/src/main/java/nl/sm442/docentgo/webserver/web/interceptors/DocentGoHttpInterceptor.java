package nl.sm442.docentgo.webserver.web.interceptors;

import nl.sm442.docentgo.webserver.web.token.TokenHolder;
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

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().add(HttpHeaders.ACCEPT, "application/json");
        request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + TokenHolder.getInstance().getToken());
        return execution.execute(request, body);
    }
}
