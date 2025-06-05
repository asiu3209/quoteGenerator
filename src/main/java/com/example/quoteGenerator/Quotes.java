package com.example.quoteGenerator;

import java.util.List;
import java.util.Random;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
//quotes api
//https://api-ninjas.com/api/quotes 
@Service
public class Quotes {
    String apiLink = "https://api.api-ninjas.com/v1/quotes";
    HttpHeaders headers;
    HttpEntity<Void> entity;

    public Quotes() {
        headers = new HttpHeaders();
        headers.set("X-Api-Key", "key");
        entity = new HttpEntity<>(headers);
    }

    private final List<String> quotes = List.of(
        "Believe in yourself.",
        "You miss 100% of the shots you don’t take.",
        "The best time to start was yesterday. The next best time is now.",
        "Push yourself, no one else is going to do it for you.",
        "Great things never come from comfort zones."
    );

    public String getQuote(){
        Random random = new Random();
        return (quotes.get(random.nextInt(quotes.size())));
    }
}
