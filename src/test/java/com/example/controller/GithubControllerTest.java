package com.example.controller;

import com.example.common.exception.ErrorMessage;
import com.example.common.exception.GithubException;
import com.example.service.GithubService;
import groovy.json.JsonBuilder;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.JSONAssertion;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.apache.http.protocol.HTTP;
import org.jboss.resteasy.reactive.ClientWebApplicationException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import io.quarkus.test.junit.mockito.InjectMock;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;


@QuarkusTest
class GithubControllerTest {

    @InjectMock
    GithubService githubService;

    @Test
    void testGetRepositoriesForUser() {
        given()
                .header("Accept","application/json")
                .pathParam("name", "BartekPiwowarczyk")
                .when().get("/api/users/{name}")
                .then().statusCode(200);

        verify(githubService).getRepositoriesForUser("application/json", "BartekPiwowarczyk");
    }

    @Test
    void  testGetRepositoriesForUserWithInvalidAcceptHeader() {
        given()
                .header("Accept","application/xml")
                .pathParam("name", "BartekPiwowarczyk")
                .when()
                .get("/api/users/{name}")
                .then()
                .statusCode(406)
                .body("message",equalTo("Wrong header"))
                .body("status",equalTo(406));
    }

    @Test
    public void testGetRepositoriesForNonexistentUser() {
        Mockito.when(githubService.getRepositoriesForUser(anyString(), anyString()))
                .thenThrow(new ClientWebApplicationException());

        given()
                .header("Accept", "application/json")
                .pathParam("name", "nonexistentUser")
                .when()
                .get("/api/users/{name}")
                .then()
                .statusCode(404)
                .body("message",equalTo("User not found"));

    }
}