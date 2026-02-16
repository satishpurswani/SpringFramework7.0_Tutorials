package learn.gog.newspring.configs;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PostExchange;

public interface RandomNumberGenerator {

    @PostExchange("/randomNumberGenerator/from/{from}/to/{to}")
    String generateRandomNumber(@PathVariable("from") int from,
                                @PathVariable("to") int to,
                                @RequestBody String s,
                                @RequestParam(value = "defaultResp", required = false) boolean defaultResp);
}
