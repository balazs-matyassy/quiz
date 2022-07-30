package hu.progmatic.quiz.service;

import hu.progmatic.quiz.form.SingleChoiceSearchForm;
import hu.progmatic.quiz.model.SingleChoiceQuestion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SingleChoiceService {
    private long counter = 0;

    private Map<Long, SingleChoiceQuestion> questions = new TreeMap<>();

    public SingleChoiceService() {
        SingleChoiceQuestion question1 = new SingleChoiceQuestion();
        question1.setQuestion("Mi Magyarország fővárosa?");
        question1.setAnswer(1);
        question1.setOptionA("Budapest");
        question1.setOptionB("Győr");
        question1.setOptionC("Sopron");
        question1.setOptionD("Miskolc");
        saveQuestion(question1);

        SingleChoiceQuestion question2 = new SingleChoiceQuestion();
        question2.setQuestion("Mi Németország fővárosa?");
        question2.setAnswer(2);
        question2.setOptionA("München");
        question2.setOptionB("Berlin");
        question2.setOptionC("Köln");
        question2.setOptionD("Frankfurt am Main");
        saveQuestion(question2);
    }

    public List<SingleChoiceQuestion> getAll() {
        return new ArrayList<>(questions.values());
    }

    public SingleChoiceQuestion getById(Long id) {
        return questions.get(id);
    }

    public List<SingleChoiceQuestion> getByForm(SingleChoiceSearchForm form) {
        List<SingleChoiceQuestion> result = new ArrayList<>();

        for (SingleChoiceQuestion question : questions.values()) {
            if (form.getId() != null && !form.getId().equals(question.getId())) {
                continue;
            }

            if (form.getQuestion() != null && !question.getQuestion().contains(form.getQuestion())) {
                continue;
            }

            result.add(question);
        }

        return result;
    }

    public SingleChoiceQuestion saveQuestion(SingleChoiceQuestion question) {
        if (question.getId() == null) {
            counter++;
            question.setId(counter);
        }

        questions.put(question.getId(), question);

        return question;
    }
}
