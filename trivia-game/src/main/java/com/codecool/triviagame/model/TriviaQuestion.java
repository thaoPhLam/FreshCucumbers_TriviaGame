package com.codecool.triviagame.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "question",
        "correct_answer",
        "incorrect_answers"
})
@Component
@Data
public class TriviaQuestion {

    @JsonProperty("question")
    public String question;

    @JsonProperty("correct_answer")
    public String correctAnswer;

    @JsonProperty("incorrect_answers")
    public List<String> inCorrectAnswers;

    @JsonProperty("all_answers")
    public Set<String> allAnswers;





}
