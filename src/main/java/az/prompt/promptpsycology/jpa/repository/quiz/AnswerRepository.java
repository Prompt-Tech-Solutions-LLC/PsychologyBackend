package az.prompt.promptpsycology.jpa.repository.quiz;

import az.prompt.promptpsycology.jpa.entity.AnswerJpa;
import az.prompt.promptpsycology.jpa.entity.QuestionJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerJpa, Long> {

}
