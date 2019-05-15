package com.codecool.triviaimages.model;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "kind",
        "title",
        "htmlTitle",
        "link",
        "displayLink",
        "snippet",
        "htmlSnippet",
        "mime",
        "image"
})
@Component
@Data
public class TriviaHint {
    @JsonProperty("link")
    public String link;

}
