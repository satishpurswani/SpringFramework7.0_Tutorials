package learn.gog.newspring.controller;

import learn.gog.newspring.service.RetryServiceAnnotationBased;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.retry.RetryException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class RetryControllerAnnotationBased {

    @Autowired
    private RetryServiceAnnotationBased retryService;

    @GetMapping("/test")
    public String test(){
        return "Working...";
    }

    @GetMapping("/retryTrigger")
    public String retryTriggerAnnotation() throws RetryException {
//        retryService.learnRetryAnnotation();// Called in Sync
        Thread.ofVirtual().start(() -> retryService.learnRetryAnnotation()); // Called in ASync
        return "<h2>Triggered Annotation Based...</h2>";

    }

}
