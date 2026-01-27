package learn.gog.newspring.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class RetryServiceAnnotationBased {

    private int counter = 1;

    @Retryable(includes = {RuntimeException.class},
            delay = 1000, // Delay by 1 second
            multiplier = 2, // Multiple last retry time by the value
            maxRetries = 5,
            jitter = 100
    )
    public void learnRetryAnnotation() {
        log.info("Executing learnRetryAnnotation method for {} time : {} ", counter, LocalDateTime.now());
        if(counter<=4){
            counter++;
            throw new RuntimeException("Throwing Runtime exception");
        }
        log.info("End learnRetryAnnotation method for 5 time : {} ", LocalDateTime.now());
        resetCounter();

    }

    private void resetCounter() {
        counter = 1;
    }

}
