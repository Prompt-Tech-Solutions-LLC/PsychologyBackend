package az.prompt.promptpsycology.dto.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class QuizRequest {
    private String quizTitle;
    private List<Map<String, String>> answers;
}
