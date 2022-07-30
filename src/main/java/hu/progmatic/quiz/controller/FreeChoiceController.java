package hu.progmatic.quiz.controller;

import hu.progmatic.quiz.model.FreeChoiceQuestion;
import hu.progmatic.quiz.service.FreeChoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// adott táblához (free_choice) tartozó
// aloldalak (megjelenítés, lekérdezések + szerkesztés)
@Controller
public class FreeChoiceController {
    // tábla + lekérdezések
    private FreeChoiceService freeChoiceService;

    public FreeChoiceController(FreeChoiceService freeChoiceService) {
        this.freeChoiceService = freeChoiceService;
    }

    @GetMapping("/freechoices")
    public String getQuestions(Model model) {
        List<FreeChoiceQuestion> questions = freeChoiceService.getAll();
        model.addAttribute("questions", questions);

        return "freechoices";
    }

    @GetMapping("/freechoices/create")
    public String createQuestion(Model model) {
        FreeChoiceQuestion question = new FreeChoiceQuestion();
        question.setQuestion("Please provide a question...");
        question.setAnswer("Please provide an answer...");

        model.addAttribute("question", question);

        return "newfreechoice";
    }
}
