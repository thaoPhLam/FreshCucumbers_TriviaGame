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


//  https://www.googleapis.com/customsearch/v1?cx=004982975868314502689:xesrxo-klao&key=AIzaSyDg7qg5somTKBK7N2FsLtWrsfLD4H_g-Ro&q=horse&searchType=image

    @Autowired
    RestTemplate restTemplate;

    private String baseUrl = "https://www.googleapis.com/customsearch/v1?cx=";

    @Value("${google.api.key}")
    private String googleSearchApi;

    @Value("${google.search.id}")
    private String googleSearchId;

    public TriviaHint searchForHint(String search) {
        String searchUrl = baseUrl + googleSearchId + "&key=" + googleSearchApi + "&q=" + search + "&searchType=image";
        ImageList images = restTemplate.getForObject(searchUrl, ImageList.class);
        List<TriviaHint> triviaHints = images.getTriviaHints();
        System.out.println(triviaHints.get(0));
        return triviaHints.get(0);
    }
}
