package az.prompt.promptpsycology.mapper;

import az.prompt.promptpsycology.dto.payload.request.Answer;
import az.prompt.promptpsycology.dto.payload.request.Question;
import az.prompt.promptpsycology.dto.Quiz;
import az.prompt.promptpsycology.dto.payload.response.QuizList;
import az.prompt.promptpsycology.jpa.entity.AnswerJpa;
import az.prompt.promptpsycology.jpa.entity.QuestionJpa;
import az.prompt.promptpsycology.jpa.entity.QuizJpa;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuizMapper {
    QuizJpa toJpa(Quiz quizInsertion);
    Quiz fromJpa(QuizJpa quizJpa);

    AnswerJpa toJpa(Answer answer);
    Answer fromJpa(AnswerJpa answerJpa);

    QuestionJpa toJpa(Question question);
    Question fromJpa(QuestionJpa questionJpa);

    QuizList toList(QuizJpa quizJpa);
}
