package personal.uma.exceptions;

import org.springframework.validation.Errors;

public class ValidationException extends Exception{
    private Errors errors;
    public ValidationException(Errors errors){
        super();
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
