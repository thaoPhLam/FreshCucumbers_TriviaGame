package com.codecool.triviaapp.controller;

import com.codecool.triviaapp.model.Score;
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
@SessionAttributes({"score", "game"})
public class AppController {

    @Autowired
    ServiceCaller serviceCaller;

    @ModelAttribute("game")
    public TriviaQuestionSelection triviaQuestionSelection() {
        return serviceCaller.retrieveTriviaQuestion();
    }



    @ModelAttribute("score")
    public Score score(){
        return new Score();
    }

    @GetMapping(value = "/game")
    public String GameView(@ModelAttribute("game") TriviaQuestionSelection triviaQuestionSelection, Model model) {
        if(triviaQuestionSelection.receivedAnswer) {
            triviaQuestionSelection = serviceCaller.retrieveTriviaQuestion();
        }
        model.addAttribute("swansonism", serviceCaller.retrieveSwansonQuote());
        model.addAttribute("question", triviaQuestionSelection.getQuestion());
        model.addAttribute("correctanswer", triviaQuestionSelection.getCorrectAnswer());
        model.addAttribute("allanswers", triviaQuestionSelection.getAllAnswers());
        model.addAttribute("gameHint", serviceCaller.retrieveTriviaHint(triviaQuestionSelection.getCorrectAnswer()));

        return "game";
    }

    @GetMapping(value = "/game-selection")
    public String gameSelection(@ModelAttribute("game") TriviaQuestionSelection triviaQuestion, String selection,
                                @ModelAttribute("score") Score score) {
        score.evaluateAnswer(selection,triviaQuestion.getCorrectAnswer());
        triviaQuestion.setReceivedAnswer(true);
        return "redirect:/game";
    }

//    @GetMapping(value = "/test-selection")
//    public void incrementScore(@ModelAttribute("game") TriviaQuestionSelection triviaQuestion, String selection,
//                               @ModelAttribute("score") Score score){
//
//
//    }

}
