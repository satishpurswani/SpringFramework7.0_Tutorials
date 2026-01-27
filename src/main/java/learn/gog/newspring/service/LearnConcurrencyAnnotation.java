package learn.gog.newspring.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.resilience.annotation.ConcurrencyLimit;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@Log4j2
public class LearnConcurrencyAnnotation {

    @ConcurrencyLimit(4)
    public void executeMethodWithConcurrencyLimit() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(2));
        log.info("Executing this method with threadName: {}. " +
                "threadGroup: {}, time: {}",
                Thread.currentThread().getName(),
                Thread.currentThread().getThreadGroup(),
                LocalDateTime.now());
    }

}
