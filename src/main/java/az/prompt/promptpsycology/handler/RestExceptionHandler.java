package az.prompt.promptpsycology.handler;

import az.prompt.promptpsycology.exception.RestException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private final ObjectMapper objectMapper;

    @ExceptionHandler(RestException.class)
    protected ResponseEntity<Object> restExceptionHandler(RestException exception) {
        ObjectNode node = objectMapper.createObjectNode();
        node.put("message", exception.getMessage());
        node.put("code", exception.getCode());
        return ResponseEntity.status(exception.getHttpStatus()).body(node);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> onThrowable(Throwable exception) {
        log.error(exception.toString(), exception);

        ObjectNode node = objectMapper.createObjectNode();
        node.put("message", exception.getMessage());
        node.put("status", "Internal error");
        return ResponseEntity.status(500).body(node);
    }
}
