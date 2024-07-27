package az.prompt.promptpsycology.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RestException {
    public BadRequestException(String code, String message) {
        super(code, message, HttpStatus.BAD_REQUEST);
    }
}
