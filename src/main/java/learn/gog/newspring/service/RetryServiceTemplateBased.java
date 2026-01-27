package learn.gog.newspring.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class RetryServiceTemplateBased {

    private int counter = 1;

    public void learnRetryTemplate() {
        log.info("Executing learnRetryTemplate method for {} time : {} ", counter, LocalDateTime.now());
        if(counter<=4){
            counter++;
            throw new RuntimeException("Throwing Runtime exception");
        }
        log.info("End learnRetryTemplate method for 5 time : {} ", LocalDateTime.now());
        resetCounter();

    }

    private void resetCounter() {
        counter = 1;
    }

}
