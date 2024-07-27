package az.prompt.promptpsycology.jpa.entity;

import az.prompt.promptpsycology.dto.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users", schema = "auth")
public class UserJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}
