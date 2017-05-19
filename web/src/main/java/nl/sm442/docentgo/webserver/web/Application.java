package nl.sm442.docentgo.webserver.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Oscar de Leeuw
 */
@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

   /* @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builmd
        der.interceptors(new DocentGoHttpInterceptor()).build();
    }*/

   /* @Bean
    public CommandLineRunner run(RestTemplate template) throws Exception {
        return args -> {
            //Person[] person = template.getForObject("https://api.fhict.nl/people/search/oosterkamp", Person[].class);
            //System.out.println(person);
        };
    }*/
}
