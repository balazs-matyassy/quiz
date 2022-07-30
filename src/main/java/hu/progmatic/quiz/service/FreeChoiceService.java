package hu.progmatic.quiz.service;

import hu.progmatic.quiz.model.FreeChoiceQuestion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// id INT NOT NULL PRIMARY KEY AUTO_INCREMENT
// question VARCHAR(255) NOT NULL
// answer VARCHAR (255) NOT NULL
@Service
public class FreeChoiceService {
    private long counter;

    // Tábla tárolása a memóriában (HEAP)
    private Map<Long, FreeChoiceQuestion> questions = new TreeMap<>();

    // ORDER BY A TreeMap miatt van.
    // SELECT * FROM free_choice ORDER BY id;
    public List<FreeChoiceQuestion> getAll() {
        return new ArrayList<>(questions.values());
    }

    // SELECT * FROM free_choice WHERE id = {long id};
    public FreeChoiceQuestion getById(long id) {
        return questions.get(id);
    }

    // Csak példa kedvéért, nem használjuk jelenleg semmire.
    // Azoknak a kérdéseknek a listája, ahol a kérdésben szerepel egy adott szó(részlet)
    // (pl. "király")
    // ORDER BY A TreeMap miatt van.
    // SELECT * FROM free_choice WHERE question LIKE '%{String pattern}%'
    // ORDER BY id;
    public List<FreeChoiceQuestion> getByQuestion(String pattern) {
        List<FreeChoiceQuestion> result = new ArrayList<>();

        for (FreeChoiceQuestion question : questions.values()) {
            if (question.getQuestion().contains(pattern)) {
                result.add(question);
            }
        }

        return result;
    }

    // question.getId() == null
    // új rekord kerül a táblába (ebben az a Map-be)
    // INSERT INTO free_choice(question, answer)
    // VALUES ({question.question}, {question.answer});
    // counter segítségével az AUTO_INCREMENT-et szimuláljuk
    //
    // question.getId() != null
    // meglévő rekord frissítése
    // UPDATE free_choice SET question = {question.question},
    // answer = {question.answer}
    // WHERE id = {question.id};
    public FreeChoiceQuestion saveQuestion(FreeChoiceQuestion question) {
        // AUTO_INCREMENT (INSERT)
        if (question.getId() == null) {
            counter++; // AUTO_INCREMENT
            question.setId(counter);
        }

        // INSERT (id null volt) vagy UPDATE (id nem volt null)
        questions.put(question.getId(), question);

        return question;
    }
}
