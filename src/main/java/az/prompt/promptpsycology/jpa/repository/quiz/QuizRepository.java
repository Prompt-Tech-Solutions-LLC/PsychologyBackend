package az.prompt.promptpsycology.jpa.repository.quiz;

import az.prompt.promptpsycology.jpa.entity.QuizJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<QuizJpa, Long> {
}
