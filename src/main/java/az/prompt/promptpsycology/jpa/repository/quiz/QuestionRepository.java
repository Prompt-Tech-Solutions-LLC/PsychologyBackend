package az.prompt.promptpsycology.jpa.repository.quiz;

import az.prompt.promptpsycology.jpa.entity.QuestionJpa;
import az.prompt.promptpsycology.jpa.entity.QuizJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionJpa, Long> {

}
