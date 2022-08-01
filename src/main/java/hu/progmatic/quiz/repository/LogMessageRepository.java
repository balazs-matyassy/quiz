package hu.progmatic.quiz.repository;

import hu.progmatic.quiz.model.LogMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMessageRepository extends CrudRepository<LogMessage, Long> {
}
