package com.codecool.triviaimages.controller;

import com.codecool.triviaimages.model.TriviaHint;
import com.codecool.triviaimages.service.TriviaHintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/triviahint")
public class TriviaHintController {

    @Autowired
    TriviaHintService triviaHintService;

    @GetMapping("/gethint")
    public TriviaHint getImageHint(@RequestParam("search") String search) {
         return triviaHintService.searchForHint(search);
    }
}
