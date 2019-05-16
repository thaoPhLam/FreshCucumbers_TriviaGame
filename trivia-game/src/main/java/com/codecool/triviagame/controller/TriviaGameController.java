package com.codecool.triviagame.controller;

import com.codecool.triviagame.model.TriviaQuestion;
import com.codecool.triviagame.service.TriviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class TriviaGameController {
    @Autowired
    TriviaService triviaService;

    @GetMapping("/get-question")
    public TriviaQuestion getQuestion(){
        return triviaService.getTriviaQuestion();
    }

}
