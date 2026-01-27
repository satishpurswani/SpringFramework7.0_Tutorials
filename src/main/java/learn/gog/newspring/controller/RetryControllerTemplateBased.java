package learn.gog.newspring.controller;

import learn.gog.newspring.service.RetryServiceTemplateBased;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.retry.RetryException;
import org.springframework.core.retry.RetryPolicy;
import org.springframework.core.retry.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class RetryControllerTemplateBased {

    @Autowired
    private RetryServiceTemplateBased retryServiceTemplateBased;


    @Autowired
    @Qualifier("retryTemplateWithRetryPolicyCustomOne")
    private RetryTemplate retryTemplate;

    @GetMapping("/retryTriggerTemplate")
    public String retryTriggerTemplate() throws RetryException {

        Thread.ofVirtual().start(() -> {
            try {
                retryTemplate.execute(() -> {
                    retryServiceTemplateBased.learnRetryTemplate();
                    return "<h2>Triggered Template Based...</h2>";
                });
            } catch (RetryException e) {
                throw new RuntimeException(e);
            }
        });
        return "<h2>Triggered Template Based...</h2>";

        /*return retryTemplate.execute(() -> {
            retryServiceTemplateBased.learnRetryTemplate();
            return "<h2>Triggered Template Based...</h2>";
        });*/
    }





}
