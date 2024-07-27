package az.prompt.promptpsycology.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {
    private final AuthenticationValidatorService authenticationValidatorService;
    private final ObjectMapper objectMapper;

    /*@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS"))
            return true;

        MilitarySession session = authenticationValidatorService.getMilitarySession(request);
        if (session == null) {
            send401Response(response);
            return false;
        }
        SessionContext.setSession(session);

        return true;
    }*/

    @SneakyThrows
    private void send401Response(HttpServletResponse response) {
        ObjectNode node = objectMapper.createObjectNode();
        node.put("status", "AUTHENTICATION_REQUIRED");
        node.put("code", 401);

        response.setContentType("application/json");
        response.setStatus(401);
        objectMapper.writeValue(response.getOutputStream(), node);
    }
}