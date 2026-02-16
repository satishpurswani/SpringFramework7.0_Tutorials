package learn.gog.newspring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(group = "randomNumberGenerator", basePackageClasses = RandomNumberGenerator.class)
public class GenerateClientForMe {

    @Bean
    RestClientHttpServiceGroupConfigurer configurer() {
        return groups -> groups.filterByName("randomNumberGenerator")
                .forEachClient((name, builder) -> builder.baseUrl("http://localhost:8081"));
    }



    //Old Approach
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
