package hu.progmatic.quiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LogMessage {
    @Id
    @GeneratedValue
    private Long id;

    private String message;

    public LogMessage() {
    }

    public LogMessage(String message) {
        this.message = message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
