package az.prompt.promptpsycology.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RestException {

    public NotFoundException(String code, String message) {
        super(code, message, HttpStatus.NOT_FOUND);
    }
}
