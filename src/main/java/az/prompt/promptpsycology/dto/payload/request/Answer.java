package az.prompt.promptpsycology.dto.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class Answer {
    private Map<String, String> answers;
}
