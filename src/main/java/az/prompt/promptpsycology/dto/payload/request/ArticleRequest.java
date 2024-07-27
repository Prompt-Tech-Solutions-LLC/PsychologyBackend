package az.prompt.promptpsycology.dto.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@Schema(description = "Request to add a new article")
public class ArticleRequest {
    @Schema(description = "Title of the article", example = "My First Article")
    private String title;

    @Schema(description = "Content of the article", example = "This is the content of the article.")
    private String content;

    @Schema(description = "Image file for the article")
    private MultipartFile imageFile;
}
