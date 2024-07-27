package az.prompt.promptpsycology.controller;

import az.prompt.promptpsycology.dto.Quiz;
import az.prompt.promptpsycology.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    @GetMapping
    private ResponseEntity<?> getQuizzes() {
        return ResponseEntity.ok().body(quizService.getQuizzes());
    }

    @PostMapping("/submit")
    private ResponseEntity<?> submitQuiz(@RequestBody Quiz quiz) {
        quizService.addQuiz(quiz);
        return ResponseEntity.ok().body("Quiz submitted successfully");
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getQuiz(@PathVariable Long id) {
        return ResponseEntity.ok().body(quizService.getQuiz(id));
    }

}
