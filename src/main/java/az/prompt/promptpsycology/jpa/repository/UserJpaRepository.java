package az.prompt.promptpsycology.jpa.repository;

import az.prompt.promptpsycology.exception.NotFoundException;
import az.prompt.promptpsycology.jpa.entity.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserJpa, Long> {
    UserJpa findFirstByUsername(String username);

    default UserJpa findFirstByUsernameSafe(String login) {
        UserJpa user = findFirstByUsername(login);
        if (user == null) {
            throw new NotFoundException("USER_NOT_FOUND", String.format("Пользователь %s не найден", login));
        }

        return user;
    }
}
