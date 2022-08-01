package hu.progmatic.quiz.service;

import hu.progmatic.quiz.form.SingleChoiceSearchForm;
import hu.progmatic.quiz.model.SingleChoiceQuestion;
import hu.progmatic.quiz.repository.SingleChoiceRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SingleChoiceService {
    // ez helyettesíti a Map-t
    private SingleChoiceRepository repository;

    private long counter = 0;

    private Map<Long, SingleChoiceQuestion> questions = new TreeMap<>();

    public SingleChoiceService(SingleChoiceRepository repository) {
        this.repository = repository;
    }

    public List<SingleChoiceQuestion> getAll() {
        return new ArrayList<>((Collection) repository.findAll());
    }

    public SingleChoiceQuestion getById(Long id) {
        // Segédosztály (csomagoló)
        // Ha nincs találat, akkor null helyett ebben az esetben is egy érvényes objektumot kapunk vissza.
        // emlékeztető: Map -> getOrDefault
        Optional<SingleChoiceQuestion> question = repository.findById(id);

        return question.orElseThrow();
    }

    public List<SingleChoiceQuestion> getByForm(SingleChoiceSearchForm form) {
        List<SingleChoiceQuestion> result = new ArrayList<>();

        for (SingleChoiceQuestion question : getAll()) {
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
        repository.save(question);

        return question;
    }
}
