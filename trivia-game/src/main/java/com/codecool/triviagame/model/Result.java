package com.codecool.triviagame.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "response_code",
        "results"
})
/*
{
        "response_code": 0,
        "results": [
        {
        "category": "Entertainment: Video Games",
        "type": "multiple",
        "difficulty": "easy",
        "question": "The Khajiit are a race of cat-like creatures from which epic series of role-playing games, set across the land of Tamriel?",
        "correct_answer": "The Elder Scrolls",
        "incorrect_answers": [
        "Lord of the Rings",
        "The Witcher",
        "Neverwinter Nights"
        ]
        }
        ]
        }
        */
@Data
public class Result {
    @JsonProperty("results")
    public List<TriviaQuestion> results;

}
