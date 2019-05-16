package com.codecool.triviagame.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class TriviaGame {
    @Autowired
    TriviaQuestion triviaQuestion;



}
