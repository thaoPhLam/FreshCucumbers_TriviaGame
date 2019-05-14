package com.codecool.swansonquotes.controller;

import com.codecool.swansonquotes.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/random-quote")
    @ResponseBody
    public String getRandomQuote() {
        return quoteService.getRandomQuote();
    }

}
