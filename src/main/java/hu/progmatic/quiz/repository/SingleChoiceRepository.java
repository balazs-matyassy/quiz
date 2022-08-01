package hu.progmatic.quiz.repository;

import hu.progmatic.quiz.model.SingleChoiceQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleChoiceRepository extends CrudRepository<SingleChoiceQuestion, Long> {
}
