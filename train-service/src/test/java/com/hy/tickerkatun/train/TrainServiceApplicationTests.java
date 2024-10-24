package com.hy.tickerkatun.train;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TrainServiceApplicationTests {
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:13.2");

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        postgreSQLContainer.start();
    }

    @Test
    void bookingTest() throws Exception {
        // should pass
        var responseBodyString = RestAssured.given()
                .contentType("application/json")
                .when()
                .post("/api/train/book/express-one/seat-1-1")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body().asString();

        assertThat(responseBodyString, Matchers.is("Forwarded to reservation service."));

        // should fail.
        var responseBodyString2 = RestAssured.given()
                .contentType("application/json")
                .when()
                .post("/api/train/book/express-one/seat-1-1")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body().asString();

        assertThat(responseBodyString, Matchers.is("Seat is already booked."));
    }
}
