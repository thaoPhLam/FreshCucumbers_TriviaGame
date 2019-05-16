package com.codecool.triviagame.service;

import com.codecool.triviagame.model.TriviaQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class TriviaApiHandler {

    @Value("${trivia.api.url}")
    private String apiLink;

    @Autowired
    RestTemplate restTemplate;

    public TriviaQuestion getTriviaQuestion(){
        System.out.println(apiLink);
        TriviaQuestion triviaQuestion = restTemplate.getForObject(apiLink, TriviaQuestion.class);
        System.out.println(triviaQuestion);
        return triviaQuestion;
    }

}
