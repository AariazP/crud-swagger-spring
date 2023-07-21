package com.arias.crudrest.controllers;

import com.arias.crudrest.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalManagementPort;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {

        restTemplateBuilder = new RestTemplateBuilder()
                .rootUri("http://localhost:"+ port);

        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void createBook() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        String json = """
                
                   {
                    "title": "The Lord of the Rings 2"
                   }
                   
                """;
        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<String> result = testRestTemplate.exchange("/books",HttpMethod.POST,request,String.class);
        assertEquals(HttpStatusCode.valueOf(200),result.getStatusCode());
    }

    @Test
    void updateBook() {


    }

    @Test
    void getBook() {
    }

    @Test
    void findAll() {
        ResponseEntity<Book[]> result = testRestTemplate.getForEntity("/books",Book[].class);
        assertEquals(HttpStatusCode.valueOf(200),result.getStatusCode());
    }
}