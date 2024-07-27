package az.prompt.promptpsycology.dto;

import az.prompt.promptpsycology.dto.payload.request.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Quiz {
    private Long id;
    private String title;
    private String description;
    private List<Question> questions;
}
