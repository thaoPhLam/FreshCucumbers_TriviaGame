package com.codecool.triviaapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class TriviaQuestionSelection {

    @JsonProperty("question")
    public String question;

    @JsonProperty("correct_answer")
    public String correctAnswer;

    @JsonProperty("incorrect_answers")
    public List<String> inCorrectAnswers;

    @JsonProperty("all_answers")
    public Set<String> allAnswers;


}
