package com.codecool.swansonquotes.service;

import com.codecool.swansonquotes.model.QuoteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${quote.url}")
    public String quoteUrl;

    public String getRandomQuote() {
        QuoteResult quoteResult = restTemplate.getForEntity(quoteUrl, QuoteResult.class).getBody();
        return quoteResult.getQuote();
    }

}
