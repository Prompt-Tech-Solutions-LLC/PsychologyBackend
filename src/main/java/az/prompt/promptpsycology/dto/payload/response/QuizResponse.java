package az.prompt.promptpsycology.dto.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class QuizResponse {
    private String grade;
    private String description;
}
