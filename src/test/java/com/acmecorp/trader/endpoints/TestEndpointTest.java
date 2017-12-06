package com.acmecorp.trader.endpoints;

import com.acmecorp.trader.TraderApplication;
import com.acmecorp.trader.repository.AuditTrailDAO;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import javax.annotation.Resource;

/**
 * Created by volen on 2017-07-31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
public class TestEndpointTest {
    @LocalServerPort
    private int serverPort;

    @TestConfiguration
    static class Config {
        @Resource(name="inMemoryAuditTrailDAO")
        AuditTrailDAO inMemoryAuditTrail;

        @Bean
        public AuditTrailDAO auditTrailDAO() {
            return inMemoryAuditTrail;
        }
    }
    
    
    @Before
    public void init(){
        RestAssured.port = serverPort;
    }

    @Test
    public void getObjectHappyPath() throws Exception {
        when().
            get("/testobjects").
        then().
            statusCode(200);
    }

    @Test
    public void storeObjectHappyPath() throws Exception {
        given().
            contentType("application/json").
            body("{\"text\":\"abc\"}").
        when().
            post("/testobjects").
        then().
            statusCode(200).
            body("text", equalTo("abc"));

}


}