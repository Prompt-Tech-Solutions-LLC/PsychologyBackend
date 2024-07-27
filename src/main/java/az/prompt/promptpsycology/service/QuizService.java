package az.prompt.promptpsycology.service;

import az.prompt.promptpsycology.dto.Quiz;
import az.prompt.promptpsycology.dto.enums.QuestionType;
import az.prompt.promptpsycology.dto.payload.request.Answer;
import az.prompt.promptpsycology.dto.payload.request.Question;
import az.prompt.promptpsycology.dto.payload.request.QuizRequest;
import az.prompt.promptpsycology.dto.payload.response.QuizList;
import az.prompt.promptpsycology.dto.payload.response.QuizResponse;
import az.prompt.promptpsycology.jpa.entity.AnswerJpa;
import az.prompt.promptpsycology.jpa.entity.QuestionJpa;
import az.prompt.promptpsycology.jpa.entity.QuizJpa;
import az.prompt.promptpsycology.jpa.repository.quiz.AnswerRepository;
import az.prompt.promptpsycology.jpa.repository.quiz.QuestionRepository;
import az.prompt.promptpsycology.jpa.repository.quiz.QuizRepository;
import az.prompt.promptpsycology.mapper.QuizMapper;
import az.prompt.promptpsycology.utils.QuizUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuizUtils quizUtils;
    private final QuizMapper quizMapper;

    public QuizResponse getGrade(QuizRequest quizRequest) {
        int score = 0;
        for (Map<String, String> answer : quizRequest.getAnswers()) {
            for (String key : answer.keySet()) {
                if(StringUtils.isNumeric(answer.get(key))){
                    score += Integer.parseInt(key);
                }
            }
        }
        String description = "";

        if (quizRequest.getQuizTitle().contains("BDI")) {
            description = quizUtils.bdiGrade(score);
        }

        //todo save to db

        return QuizResponse.builder()
                .grade(String.valueOf(score))
                .description(description)
                .build();
    }

    @Transactional
    public void addQuiz(Quiz quiz) {
        QuizJpa quizJpa = new QuizJpa();
        quizJpa.setTitle(quiz.getTitle());
        quizJpa.setDescription(quiz.getDescription());

        for (Question question : quiz.getQuestions()) {
            QuestionJpa questionJpa = new QuestionJpa();
            questionJpa.setQuestion(question.getQuestion());
            questionJpa.setQuestionType(question.getQuestionType());

            for (Answer answer : question.getAnswers()) {
                AnswerJpa answerJpa = new AnswerJpa();
                answerJpa.setAnswers(answer.getAnswers());
                questionJpa.addAnswer(answerJpa);
            }

            quizJpa.addQuestion(questionJpa);
        }

        quizRepository.save(quizJpa);
    }

    public Quiz getQuiz(Long id) {
        QuizJpa quizJpa = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        return quizMapper.fromJpa(quizJpa);
    }

    public List<QuizList> getQuizzes() {
        List<QuizJpa> quizzes = quizRepository.findAll();
        return quizzes.stream().map(quizMapper::toList).toList();
    }
}
