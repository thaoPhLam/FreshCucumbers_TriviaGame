package com.codecool.triviaapp.service;

import com.codecool.triviaapp.model.SwansonQuoteSelection;
import com.codecool.triviaapp.model.TriviaHintSelection;
import com.codecool.triviaapp.model.TriviaQuestionSelection;
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

    @Value("${trivia.url}")
    private String triviaUrl;

    public TriviaQuestionSelection retrieveTriviaQuestion() {
        return restTemplate.getForObject(triviaUrl, TriviaQuestionSelection.class);
    }

    public String retrieveSwansonQuote() {
        SwansonQuoteSelection swansonQuoteSelection = restTemplate.getForObject(swansonUrl, SwansonQuoteSelection.class);
        return swansonQuoteSelection.getQuote();
    }

    public String retrieveTriviaHint(String search) {
        String searchHintUrl = hintUrl + "?search=" + search;
        TriviaHintSelection body = restTemplate.getForEntity(searchHintUrl, TriviaHintSelection.class).getBody();
        return body.getLink();
    }
}
