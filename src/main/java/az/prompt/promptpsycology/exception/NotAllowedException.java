package az.prompt.promptpsycology.exception;

import org.springframework.http.HttpStatus;

public class NotAllowedException extends RestException {
    public NotAllowedException(String code, String message) {
        super(code, message, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
