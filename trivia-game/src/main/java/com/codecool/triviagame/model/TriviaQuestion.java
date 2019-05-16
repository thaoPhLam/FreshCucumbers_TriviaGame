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
        "result"
})
@Component
@Data
public class TriviaQuestion {

    /*
    "category": "Entertainment: Board Games",
"type": "multiple",
"difficulty": "easy",
"question": "How many spaces are there on a standard Monopoly board?",
"correct_answer": "40",
"incorrect_answers": [
"28",
"55",
"36"
     */
/*
    @JsonProperty("results")
    private String results;*/

    @JsonProperty("type")
    private String type;

    @JsonProperty("difficulty")
    private String difficulty;

    @JsonProperty("question")
    private String question;

    @JsonProperty("correct_answer")
    private String correctAnswer;

    @JsonProperty("incorrect_answers")
    private List<String> inCorrectAnswers;

}
