package at.spengergasse.entities;

import javax.persistence.*;

@Entity
@Table(name = "a_answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int a_id;

    private String a_text;

    private boolean a_correct;

    @ManyToOne
    @JoinColumn(name = "fk_q_id")
    private Question question;

    // Corrected Getter and Setter methods
    public int getAId() {
        return a_id;
    }

    public void setAId(int a_id) {
        this.a_id = a_id;
    }

    public String getAText() {
        return a_text;
    }

    public void setAText(String a_text) {
        this.a_text = a_text;
    }

    public boolean isACorrect() {
        return a_correct;
    }

    public void setACorrect(boolean a_correct) {
        this.a_correct = a_correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}