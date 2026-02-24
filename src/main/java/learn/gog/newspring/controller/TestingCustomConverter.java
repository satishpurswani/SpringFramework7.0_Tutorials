package learn.gog.newspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@RestController
public class TestingCustomConverter {

    @Autowired
    private RestClient restClient;

    @PostMapping(value = "restClientApproach/randomNumberGenerator/from/{from}/to/{to}", version = "1")
    public String restClientApproachApproachgenerateRandomNumber(@PathVariable("from") int from,
                                                  @PathVariable("to") int to,
                                                  @RequestBody String s,
                                                  @RequestParam(value = "defaultResp", required = false) boolean defaultResp){

        return restClient
                .post()
                .uri(uriBuilder -> uriBuilder
                        .scheme("HTTP")
                        .host("localhost")
                        .port(8081)
                        .path("/randomNumberGenerator/from/{from}/to/{to}")
                        .query("defaultResp=" + defaultResp)
                        .build(from, to))
                .body(s)
                .retrieve()
                .body(String.class);
    }

}
