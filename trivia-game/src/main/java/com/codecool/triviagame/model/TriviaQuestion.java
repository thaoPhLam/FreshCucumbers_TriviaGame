package com.codecool.triviagame.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "category",
        "type",
        "difficulty",
        "question",
        "correct_answer",
        "incorrect_answers"
})
@Component
@Data
public class TriviaQuestion {

    @JsonProperty("category")
    public String category;

    @JsonProperty("type")
    public String type;

    @JsonProperty("difficulty")
    public String difficulty;

    @JsonProperty("question")
    public String question;

    @JsonProperty("correct_answer")
    public String correctAnswer;

    @JsonProperty("incorrect_answers")
    public List<String> inCorrectAnswers;



}
