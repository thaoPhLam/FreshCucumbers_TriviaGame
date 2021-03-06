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
        if(triviaQuestionSelection.isReceivedAnswer()) {
            TriviaQuestionSelection triviaQuestionSelectionTemp = serviceCaller.retrieveTriviaQuestion();
            triviaQuestionSelection.setQuestion(triviaQuestionSelectionTemp.question);
            triviaQuestionSelection.setCorrectAnswer(triviaQuestionSelectionTemp.correctAnswer);
            triviaQuestionSelection.setInCorrectAnswers(triviaQuestionSelectionTemp.inCorrectAnswers);
            triviaQuestionSelection.setAllAnswers(triviaQuestionSelectionTemp.allAnswers);
            System.out.println("Game screen " + triviaQuestionSelection.getQuestion());
            triviaQuestionSelection.setReceivedAnswer(false);
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
        System.out.println("Selection screen " + triviaQuestion.question);
        score.evaluateAnswer(selection,triviaQuestion.getCorrectAnswer());
        System.out.println(selection + score);
        triviaQuestion.setReceivedAnswer(true);
        return "redirect:/game";
    }

    @GetMapping(value = "/game-reset")
    public String resetGame(@ModelAttribute("score") Score score) {
        Score tempScore = new Score();
        score.setScore(tempScore.getScore());
        return "redirect:/game";
    }



}
