package learn.gog.newspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.retry.RetryPolicy;
import org.springframework.core.retry.RetryTemplate;
import org.springframework.resilience.annotation.EnableResilientMethods;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
@EnableResilientMethods
public class NewspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewspringApplication.class, args);
	}

	@Bean
	@Primary
	public RetryPolicy retryPolicyCustomOne(){
		return RetryPolicy.builder()
				.includes(RuntimeException.class)
				.delay(Duration.of(1, ChronoUnit.SECONDS))
				.multiplier(2)
				.maxRetries(5L)
				.jitter(Duration.ofMillis(100))
				.build();
	}

	@Bean("retryTemplateWithRetryPolicyCustomOne")
	@Primary
	public RetryTemplate retryTemplateWithRetryPolicyCustomOne(){
		return new RetryTemplate(retryPolicyCustomOne());
	}

}
