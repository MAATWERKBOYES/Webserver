package nl.sm442.docentgo.webserver.web;

import nl.sm442.docentgo.webserver.web.interceptors.DocentGoHttpInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Oscar de Leeuw
 */
@Configuration
public class WebConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.interceptors(new DocentGoHttpInterceptor()).build();
    }
}
