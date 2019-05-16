package com.codecool.triviagame.service;

import com.codecool.triviagame.model.SwansonQuoteSelection;
import com.codecool.triviagame.model.TriviaHintSelection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceCaller {

    @Autowired
    RestTemplate restTemplate;

    @Value("${swanson.url}")
    private String swansonUrl;

    @Value("${hint.url}")
    private String hintUrl;

    public String retrieveSwansonQuote() {
        SwansonQuoteSelection body = restTemplate.getForEntity(swansonUrl, SwansonQuoteSelection.class).getBody();
        return body.getQuote();
    }

    public String retrieveTriviaHint(String search) {
        String searchHintUrl = hintUrl + "?search=" + search;
        TriviaHintSelection body = restTemplate.getForEntity(searchHintUrl, TriviaHintSelection.class).getBody();
        return body.getLink();
    }
}
