package com.codecool.triviagame.service;

import com.codecool.triviagame.model.Result;
import com.codecool.triviagame.model.TriviaQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TriviaService {

    @Value("${trivia.api.url}")
    private String apiLink;

    @Autowired
    RestTemplate restTemplate;

    public TriviaQuestion getTriviaQuestion(){
        System.out.println(apiLink);
        Result triviaQuestions = restTemplate.getForObject(apiLink, Result.class);
        List<TriviaQuestion> triviaQuestion = triviaQuestions.getResults();

        Set<String> allAnswers = addAllAnswer(triviaQuestion.get(0).correctAnswer, triviaQuestion.get(0).inCorrectAnswers);
        triviaQuestion.get(0).setAllAnswers(allAnswers);
        System.out.println(allAnswers);
        return triviaQuestion.get(0);
    }

    private Set<String> addAllAnswer(String correctAnswer, List<String> wrongAnswers) {
        Set<String> collectAnswers = new HashSet<>(4);
        collectAnswers.add(wrongAnswers.get(0));
        collectAnswers.add(wrongAnswers.get(1));
        collectAnswers.add(wrongAnswers.get(2));
        collectAnswers.add(correctAnswer);
        return collectAnswers;


    }
}
