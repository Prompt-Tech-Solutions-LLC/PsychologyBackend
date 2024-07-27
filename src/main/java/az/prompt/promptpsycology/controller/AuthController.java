package az.prompt.promptpsycology.controller;

import az.prompt.promptpsycology.dto.UserDto;
import az.prompt.promptpsycology.dto.payload.request.UserAuthenticationInfo;
import az.prompt.promptpsycology.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "AuthenticationController", description = "API for user authentication")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Login with username and password")
    @PostMapping("/login")
    public String login(@RequestBody UserAuthenticationInfo authenticationInfo) {
        return authenticationService.login(authenticationInfo);
    }

    @Operation(summary = "Register with username and password")
    @PostMapping("/signup")
    public void signUp(@RequestBody UserDto userDto) {
        authenticationService.register(userDto);
    }
}
