package com.example.SpringBootSecurityAPI;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SessionControllerTest {
    private static Jedis jedis;
    private static TestRestTemplate testRestTemplate;
    private static TestRestTemplate testRestTemplateWithAuth;
    private String testUrl = "http://localhost:8080/session";
    @BeforeAll
    public static void clearRedisData() {
        testRestTemplate = new TestRestTemplate();
        testRestTemplateWithAuth = new TestRestTemplate("namhm", "codejava");

        jedis = new Jedis("localhost", 6379);
        jedis.flushAll();
    }
    @Test
    public void testRedisIsEmpty() {
        Set<String> result = jedis.keys("*");
        assertEquals(0, result.size());
    }

    @Test
    public void testUnauthenticatedCantAccess() {
        ResponseEntity<String> result = testRestTemplate.getForEntity(testUrl, String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
    }
    @Test
    public void testRedisControlsSession() {
        ResponseEntity<String> result = testRestTemplateWithAuth.getForEntity(testUrl, String.class);
        assertEquals("Session", result.getBody()); //login worked

        Set<String> redisResult = jedis.keys("*");
        assertTrue(redisResult.size() > 0);

        String sessionCookie = Objects.requireNonNull(result.getHeaders().get("Set-Cookie")).getFirst().split(";")[0];
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", sessionCookie);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        result = testRestTemplate.exchange(testUrl, HttpMethod.GET, httpEntity, String.class);
        assertEquals("Session", result.getBody()); //access with session works worked

        jedis.flushAll(); //clear all keys in redis

        result = testRestTemplate.exchange(testUrl, HttpMethod.GET, httpEntity, String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
    }
}
