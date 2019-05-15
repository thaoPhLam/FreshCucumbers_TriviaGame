package com.codecool.triviaimages.converter;


import java.util.List;

import com.codecool.triviaimages.model.TriviaHint;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "kind",
        "url",
        "queries",
        "context",
        "searchInformation",
        "triviaHints"
})
@Data
public class ImageList {
    @JsonProperty("items")
    public List<TriviaHint> triviaHints = null;

}
