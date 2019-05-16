package com.codecool.triviaapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Score {

    @JsonProperty("score")
    private int score = 0;

    public void evaluateAnswer(String userSelection, String correctSelection){
        if (userSelection.equals(correctSelection)){
            this.score++;
        }
    }

}
