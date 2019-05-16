package com.codecool.triviagame.service;

import com.codecool.triviagame.model.Result;
import com.codecool.triviagame.model.TriviaQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TriviaApiHandler {

    @Value("${trivia.api.url}")
    private String apiLink;

    @Autowired
    RestTemplate restTemplate;

    public TriviaQuestion getTriviaQuestion(){
        System.out.println(apiLink);
        Result triviaQuestions = restTemplate.getForObject(apiLink, Result.class);
        List<TriviaQuestion> triviaQuestion = triviaQuestions.getResults();

        return triviaQuestion.get(0);
    }

}
