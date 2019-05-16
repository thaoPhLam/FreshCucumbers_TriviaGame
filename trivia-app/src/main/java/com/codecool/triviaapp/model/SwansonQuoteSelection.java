package com.codecool.triviaapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SwansonQuoteSelection {

    @JsonProperty("quote")
    private String quote;
}
