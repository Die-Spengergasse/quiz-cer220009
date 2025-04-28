package at.spengergasse.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "q_questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int q_id;

    private String q_text;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<answer> answers;

    // Corrected Getter and Setter methods
    public int getQId() {
        return q_id;
    }

    public void setQId(int q_id) {
        this.q_id = q_id;
    }

    public String getQText() {
        return q_text;
    }

    public void setQText(String q_text) {
        this.q_text = q_text;
    }

    public List<answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<answer> answers) {
        this.answers = answers;
    }
}