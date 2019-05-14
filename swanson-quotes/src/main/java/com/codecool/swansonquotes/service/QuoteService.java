package com.codecool.swansonquotes.service;

import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    public String getRandomQuote() {
        return "https://ron-swanson-quotes.herokuapp.com/v2/quotes";
    }

}
