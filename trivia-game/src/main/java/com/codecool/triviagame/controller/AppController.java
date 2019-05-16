package com.codecool.triviagame.controller;

import com.codecool.triviagame.model.TriviaQuestion;
import com.codecool.triviagame.service.ServiceCaller;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Data
@Controller
@SessionAttributes({"game"})
public class AppController {

    @Autowired
    ServiceCaller serviceCaller;

    @ModelAttribute("game")
    public TriviaQuestion getGame() {
        return new TriviaQuestion();
    }

    @GetMapping(value = "/game")
    public String GameView(Model model) {
        model.addAttribute("swansonism", serviceCaller.retrieveSwansonQuote());

        return "game";
    }

    @GetMapping(value = "/game-selection")
    public String gameSelection(@ModelAttribute("game") TriviaQuestion triviaQuestion, int selection) {
        return "redirect:/game";
    }

    @GetMapping(value = "/game-hint")
    public String gameHint(@ModelAttribute("game") TriviaQuestion triviaQuestion, String hint, Model model ) {
        model.addAttribute("gameHint", serviceCaller.retrieveTriviaHint(hint));
        return "redirect:/game";
    }
}
