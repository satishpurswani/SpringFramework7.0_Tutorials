package learn.gog.newspring.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.web.client.ApiVersionInserter;

class TestingCustomConverterTest {

    private RestTestClient client;

    @BeforeEach
    public void setup() {
        // Binds to a specific controller instance
        client = RestTestClient
                .bindToServer()
                .baseUrl("http://localhost:8080")
                .apiVersionInserter(ApiVersionInserter.builder()
                        .withVersionFormatter(version -> "1")
                        .useHeader("API-Version").build())
                .build();
    }

    @Test
    void test() {
        client.post()
                .uri(uriBuilder -> uriBuilder
                        .path("restClientApproach/randomNumberGenerator/from/{from}/to/{to}")
                        .query("defaultResp=" + false)
                        .build(1, 10))
                .apiVersion(1)
                .body("Test")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK)
                .expectBody(String.class);

    }
}