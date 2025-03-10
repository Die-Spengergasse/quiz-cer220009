package at.spengergasse;

import at.spengergasse.entities.Question;

import java.util.ArrayList;
import java.util.List;

public class quiz {

    private List<Question> questions = new ArrayList<Question>();

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
