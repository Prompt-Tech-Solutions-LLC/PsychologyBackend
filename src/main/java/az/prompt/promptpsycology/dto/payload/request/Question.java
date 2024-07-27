package az.prompt.promptpsycology.dto.payload.request;

import az.prompt.promptpsycology.dto.enums.QuestionType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Question {
    private String question; // 2+2 = ?
    private QuestionType questionType; // ЗАКРЫТЫЙ ИЛИ ОТКРЫТЫЙ ВОПРОС
    private List<Answer> answers;
}
