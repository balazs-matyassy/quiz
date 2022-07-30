package hu.progmatic.quiz.controller;

import hu.progmatic.quiz.form.SingleChoiceSearchForm;
import hu.progmatic.quiz.model.SingleChoiceQuestion;
import hu.progmatic.quiz.service.SingleChoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SingleChoiceController {
    private SingleChoiceService singleChoiceService;

    public SingleChoiceController(SingleChoiceService singleChoiceService) {
        this.singleChoiceService = singleChoiceService;
    }

    @GetMapping("/singlechoices")
    public String getQuestions(Model model) {
        List<SingleChoiceQuestion> questions = singleChoiceService.getAll();
        model.addAttribute("questions", questions);

        return "singlechoices";
    }

    @GetMapping("/singlechoices/{id}")
    public String viewQuestion(@PathVariable long id, Model model) {
        SingleChoiceQuestion question = singleChoiceService.getById(id);
        model.addAttribute("question", question);

        return "viewsinglechoice";
    }

    @GetMapping("/singlechoices/create")
    public String createQuestion(Model model) {
        // üres űrlap megjelenítése
        // lehetőség lenne default értékek megadására (pl. question.setAnswer(3));
        model.addAttribute("question", new SingleChoiceQuestion());

        return "newsinglechoice";
    }

    @PostMapping("/singlechoices/create")
    public String saveNewQuestion(SingleChoiceQuestion question) {
        singleChoiceService.saveQuestion(question);

        return "redirect:/singlechoices";
    }

    @GetMapping("/singlechoices/search")
    public String searchQuestions(Model model) {
        List<SingleChoiceQuestion> questions = singleChoiceService.getAll();
        model.addAttribute("form", new SingleChoiceSearchForm());
        model.addAttribute("questions", questions);

        return "searchsinglechoices";
    }

    @PostMapping("/singlechoices/search")
    public String displaySearchResults(SingleChoiceSearchForm form, Model model) {
        List<SingleChoiceQuestion> questions = singleChoiceService.getByForm(form);
        model.addAttribute("form", form);
        model.addAttribute("questions", questions);

        return "searchsinglechoices";
    }
}
