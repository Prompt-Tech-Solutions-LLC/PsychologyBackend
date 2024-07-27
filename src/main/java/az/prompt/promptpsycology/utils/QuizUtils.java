package az.prompt.promptpsycology.utils;

import org.springframework.stereotype.Component;

@Component
public class QuizUtils {

    public String bdiGrade (int score) {
        if (score <= 9) {
            return "Отсутствие депрессивных симптомов";
        } else if (score >= 10 && score <= 15) {
            return "Легкая депрессия (субдепрессия)";
        } else if (score >= 16 && score <= 19) {
            return "Умеренная депрессия";
        } else if (score >= 20 && score <= 29) {
            return "Выраженная депрессия (средней тяжести)";
        } else if (score >= 30 && score <= 63) {
            return "Тяжелая депрессия";
        } else {
            return "Произошла непредвиденная ошибка";
        }
    }
}
