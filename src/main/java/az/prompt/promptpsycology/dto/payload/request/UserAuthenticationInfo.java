package az.prompt.promptpsycology.dto.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Model for user authentication")
public class UserAuthenticationInfo {
    @NotNull(message = "Login cannot be empty")
    @Schema(description = "User's login", requiredMode = Schema.RequiredMode.REQUIRED, example = "user123")
    private String login;

    @NotNull(message = "Password cannot be empty")
    @Schema(description = "User's password", requiredMode = Schema.RequiredMode.REQUIRED, example = "password123")
    private String password;
}
