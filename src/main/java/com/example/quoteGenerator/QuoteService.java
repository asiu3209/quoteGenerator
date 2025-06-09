package com.example.quoteGenerator;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
//quotes api
//https://api-ninjas.com/api/quotes 
import org.springframework.web.client.RestTemplate;
@Service
public class QuoteService{
    private final String apiLink = "https://api.api-ninjas.com/v1/quotes";
    private final String apiKey = "ChDH9xPuoyZa7gH8+I+Wbg==3NDKmvBplYxRDz0p";
    HttpHeaders headers;
    HttpEntity<Void> entity;

    public Quote generateQuote() {
        RestTemplate restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.set("X-Api-Key", apiKey);
        entity = new HttpEntity<>(headers);
        ResponseEntity<Quote[]> response = restTemplate.exchange(
            apiLink,
            HttpMethod.GET,
            entity,
            Quote[].class
        );
        Quote[] quotes = response.getBody();
        return (quotes != null && quotes.length > 0) ? quotes[0] : null;
    }
}
