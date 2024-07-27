package az.prompt.promptpsycology.dto;

import az.prompt.promptpsycology.dto.enums.RoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Model for user registration")
public class UserDto {
    @Schema(description = "User's username", example = "user123")
    private String username;

    @Schema(description = "User's password", example = "password123")
    private String password;

    @Schema(description = "User's email", example = "user@example.com")
    private String email;

    @Schema(description = "User's first name", example = "John")
    private String name;

    @Schema(description = "User's surname", example = "Doe")
    private String surname;

    @Schema(description = "User's role")
    private RoleEnum role;
}
