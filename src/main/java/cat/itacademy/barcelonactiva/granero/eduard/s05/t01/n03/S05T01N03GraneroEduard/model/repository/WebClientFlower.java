package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n03.S05T01N03GraneroEduard.model.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientFlower {
    @Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl("http://localhost:9001").build();
    }
}
