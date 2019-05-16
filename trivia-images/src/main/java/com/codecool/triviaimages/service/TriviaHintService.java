package com.codecool.triviaimages.service;

import com.codecool.triviaimages.converter.ImageList;
import com.codecool.triviaimages.model.TriviaHint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TriviaHintService {



    @Autowired
    RestTemplate restTemplate;

    @Value("${google.custom.search}")
    private String baseUrl;

    @Value("${google.api.key}")
    private String googleSearchApi;

    @Value("${google.search.id}")
    private String googleSearchId;

    public TriviaHint searchForHint(String search) {
        String searchUrl = baseUrl + googleSearchId + "&key=" + googleSearchApi + "&q=" + search + "&searchType=image";
        System.out.println(searchUrl);
        ImageList images = restTemplate.getForObject(searchUrl, ImageList.class);
        List<TriviaHint> triviaHints = images.getTriviaHints();
        System.out.println(triviaHints.get(0));
        return triviaHints.get(0);
    }
}
