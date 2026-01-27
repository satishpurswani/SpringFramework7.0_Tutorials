package learn.gog.newspring.controller;

import learn.gog.newspring.service.LearnConcurrencyAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConcurrencyController {

    @Autowired
    private LearnConcurrencyAnnotation learnConcurrencyAnnotation;

    @GetMapping("/learnConcurrency")
    public String learnConcurrency() {
        for (int i = 0; i < 4; i++) {
            Thread.ofVirtual().start(() ->
            {
                try {
                    learnConcurrencyAnnotation.executeMethodWithConcurrencyLimit();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return "Triggered Concurrency Methods...";
    }
}
