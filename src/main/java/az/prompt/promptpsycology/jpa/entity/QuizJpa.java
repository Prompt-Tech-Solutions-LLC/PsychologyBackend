package az.prompt.promptpsycology.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "quiz", schema = "quiz")
public class QuizJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<QuestionJpa> questions = new ArrayList<>();

    public void addQuestion(QuestionJpa question) {
        questions.add(question);
        question.setQuiz(this);
    }
}

