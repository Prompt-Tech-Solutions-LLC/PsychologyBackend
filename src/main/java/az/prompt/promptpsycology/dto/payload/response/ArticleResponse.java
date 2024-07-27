package az.prompt.promptpsycology.dto.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ArticleResponse {
    private String title;
    private String content;
    private String imageId;
}
