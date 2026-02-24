package learn.gog.newspring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class CustomRestClient {

    @Bean
    RestClient getRestClient() {
        return RestClient.builder().build();
    }

}
