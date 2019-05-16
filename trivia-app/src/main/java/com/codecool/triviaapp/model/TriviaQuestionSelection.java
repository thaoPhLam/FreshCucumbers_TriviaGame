package com.codecool.triviaapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TriviaQuestionSelection {

    @JsonProperty("question")
    public String question;

    @JsonProperty("correct_answer")
    public String correctAnswer;

    @JsonProperty("incorrect_answers")
    public List<String> inCorrectAnswers;
}
