package com.codecool.triviaapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TriviaQuestionSelection {

    @JsonProperty("question")
    public String question;

    @JsonProperty("correct_answer")
    public String correctAnswer;

    @JsonProperty("incorrect_answers")
    public List<String> inCorrectAnswers;

    @JsonProperty("all_answers")
    public Set<String> allAnswers;

    @JsonProperty("answer_received")
    public boolean receivedAnswer = false;


}
