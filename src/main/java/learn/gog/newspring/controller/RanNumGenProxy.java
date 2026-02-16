package learn.gog.newspring.controller;

import learn.gog.newspring.configs.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class RanNumGenProxy {

    @Autowired
    RandomNumberGenerator randomNumberGenerator;

    @PostMapping(value = "/randomNumberGenerator/from/{from}/to/{to}", version = "1")
    public String generateRandomNumber(@PathVariable("from") int from,
                                       @PathVariable("to") int to,
                                       @RequestBody String s,
                                       @RequestParam(value = "defaultResp", required = false) boolean defaultResp) {
        //Logic
        return randomNumberGenerator.generateRandomNumber(from, to, s, defaultResp);
    }


    //Old Approach
    @Autowired
    RestTemplate restTemplate;


    @PostMapping(value = "oldApproach/randomNumberGenerator/from/{from}/to/{to}", version = "1")
    public String oldApproachgenerateRandomNumber(@PathVariable("from") int from,
                                                  @PathVariable("to") int to,
                                                  @RequestBody String s,
                                                  @RequestParam(value = "defaultResp", required = false) boolean defaultResp) {
        var generatedURl = "http://localhost:8081/randomNumberGenerator/from/" + from + "/to/" + to + "?defaultResp=" + defaultResp;
        return restTemplate.postForObject(generatedURl, s, String.class);
    }


}
