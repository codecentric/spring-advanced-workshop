package de.codecentric.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Lösung 2.1
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Lösung 1.4
    @ExceptionHandler(AnimalNotFoundException.class)
    public ResponseEntity<String> handleAnimalNotFoundException(AnimalNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Lösung 2.2
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, org.springframework.http.HttpHeaders headers, HttpStatusCode status, org.springframework.web.context.request.WebRequest request) {
        String error = "Malformed JSON request";
        return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
    }

    // Lösung Bonus.2
    @ExceptionHandler(InvalidAnimalDataException.class)
    public ResponseEntity<String> handleInvalidAnimalDataException(InvalidAnimalDataException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
