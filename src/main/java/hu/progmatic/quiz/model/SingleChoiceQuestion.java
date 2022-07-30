package hu.progmatic.quiz.model;

public class SingleChoiceQuestion {
    private Long id;

    private String question;

    private int answer;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    // NEM KÖTELEZŐ, DE SZEBB
    // EMLÉKEZTETŐ: HA NINCS EGYETLEN KONSTRUKTOR SEM,
    // AKKOR A JAVA AUTOMATIKUSAN GENERÁL EGY DEFAULT KONSTRUKTORT.
    public SingleChoiceQuestion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
}
