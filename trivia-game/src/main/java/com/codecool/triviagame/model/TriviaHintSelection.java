package com.codecool.triviagame.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TriviaHintSelection {
    @JsonProperty("link")
    public String link;
}
