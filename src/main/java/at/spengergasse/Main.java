package at.spengergasse;

import at.spengergasse.entities.answer;
import at.spengergasse.entities.Question;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("demo").createEntityManager();

        // Load questions and answers from the database
        TypedQuery<Question> query = em.createQuery("select q from Question q", Question.class);
        List<Question> questions = query.getResultList();

        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;

        // Start the quiz
        for (Question question : questions) {
            System.out.println("Frage: " + question.getQText());
            List<answer> answers = question.getAnswers();

            // Display answers
            for (int i = 0; i < answers.size(); i++) {
                System.out.println((i + 1) + ": " + answers.get(i).getAText());
            }

            // Read user input
            System.out.print("Deine Antwort (Nummer): ");
            int userAnswer = scanner.nextInt();

            // Check the answer
            if (answers.get(userAnswer - 1).isACorrect()) {
                System.out.println("Richtig!");
                correctAnswers++;
            } else {
                System.out.println("Falsch! Die richtige Antwort wäre: ");
                for (at.spengergasse.entities.answer answer : answers) {
                    if (answer.isACorrect()) {
                        System.out.println(answer.getAText());
                        break;
                    }
                }
            }
            System.out.println();
        }

        // Display results
        System.out.println("Du hast " + correctAnswers + " von " + questions.size() + " Fragen richtig beantwortet.");
        System.out.println("Erfolgsquote: " + (correctAnswers * 100 / questions.size()) + "%");

        em.close();
        scanner.close();
    }
}