package com.codecool.triviaapp.controller;

import com.codecool.triviaapp.model.TriviaQuestionSelection;
import com.codecool.triviaapp.service.ServiceCaller;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Data
@Controller
@SessionAttributes
public class AppController {

    @Autowired
    ServiceCaller serviceCaller;

    @ModelAttribute("game")
    public TriviaQuestionSelection triviaQuestionSelection() {
        return serviceCaller.retrieveTriviaQuestion();
    }

    @GetMapping(value = "/game")
    public String GameView(@ModelAttribute("game") TriviaQuestionSelection triviaQuestionSelection, Model model) {
        model.addAttribute("swansonism", serviceCaller.retrieveSwansonQuote());
        model.addAttribute("question", triviaQuestionSelection.getQuestion());
        model.addAttribute("correctanswer", triviaQuestionSelection.getCorrectAnswer());
        model.addAttribute("allanswers", triviaQuestionSelection.getAllAnswers());
        model.addAttribute("gameHint", "https://thehorse.com/wp-content/uploads/2017/09/paint-horse-running-in-field.jpg");

        return "game";
    }

    @GetMapping(value = "/game-selection")
    public String gameSelection(@ModelAttribute("game") TriviaQuestionSelection triviaQuestion, int selection) {
        return "redirect:/game";
    }

    @GetMapping(value = "/game-hint")
    public String gameHint(@ModelAttribute("game") TriviaQuestionSelection triviaQuestion, String hint, Model model ) {

        return "redirect:/game";
    }
}
