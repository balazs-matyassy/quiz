package hu.progmatic.quiz.service;

import hu.progmatic.quiz.form.SingleChoiceSearchForm;
import hu.progmatic.quiz.model.LogMessage;
import hu.progmatic.quiz.model.SingleChoiceQuestion;
import hu.progmatic.quiz.repository.LogMessageRepository;
import hu.progmatic.quiz.repository.SingleChoiceRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SingleChoiceService {
    // ez helyettesíti a Map-t
    private SingleChoiceRepository singleChoiceRepository;

    private LogMessageRepository logMessageRepository;

    private long counter = 0;

    private Map<Long, SingleChoiceQuestion> questions = new TreeMap<>();

    public SingleChoiceService(SingleChoiceRepository repository, LogMessageRepository logMessageRepository) {
        this.singleChoiceRepository = repository;
        this.logMessageRepository = logMessageRepository;
    }

    public List<SingleChoiceQuestion> getAll() {
        return new ArrayList<>((Collection) singleChoiceRepository.findAll());
    }

    public SingleChoiceQuestion getById(Long id) {
        // Segédosztály (csomagoló)
        // Ha nincs találat, akkor null helyett ebben az esetben is egy érvényes objektumot kapunk vissza.
        // emlékeztető: Map -> getOrDefault
        Optional<SingleChoiceQuestion> question = singleChoiceRepository.findById(id);

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
        singleChoiceRepository.save(question);
        logMessageRepository.save(new LogMessage("New single choice question saved."));

        return question;
    }
}
