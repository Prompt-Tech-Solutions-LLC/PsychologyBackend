package az.prompt.promptpsycology.service;

import az.prompt.promptpsycology.config.CommonProperties;
import az.prompt.promptpsycology.dto.UserDto;
import az.prompt.promptpsycology.dto.enums.RoleEnum;
import az.prompt.promptpsycology.dto.payload.request.UserAuthenticationInfo;
import az.prompt.promptpsycology.exception.BadRequestException;
import az.prompt.promptpsycology.exception.UnauthorizedException;
import az.prompt.promptpsycology.jpa.entity.UserJpa;
import az.prompt.promptpsycology.jpa.repository.UserJpaRepository;
import az.prompt.promptpsycology.mapper.UserMapper;
import az.prompt.promptpsycology.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserJpaRepository usersRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final CommonProperties commonProperties;

    public String login(UserAuthenticationInfo authenticationInfo) {
        UserDto user = userMapper.fromUserJpa(usersRepository.findFirstByUsernameSafe(authenticationInfo.getLogin()));
        if (!passwordEncoder.matches(authenticationInfo.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("WRONG_PASSWORD", "Неверный пароль");
        }

        return jwtService.generateToken();
    }

    public void register(UserDto userDto) {
        String login = userDto.getName();
        if (usersRepository.findFirstByUsername(login) != null) {
            throw new BadRequestException("USER_ALREADY_REGISTER", String.format("Логин %s уже используется", login));
        }

        String hashPassword = passwordEncoder.encode(userDto.getPassword());
        UserJpa user = new UserJpa();

        if(userDto.getRole() == RoleEnum.ROLE_ADMIN && !commonProperties.isDevMode()) {
            System.out.println("Only for dev mode");
            userDto.setRole(RoleEnum.ROLE_USER);
        }

        user.setUsername(login);
        user.setPassword(hashPassword);
        user.setRole(userDto.getRole());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());

        usersRepository.save(user);
    }
}
