package de.codecentric.app.exception;

public class InvalidAnimalDataException extends RuntimeException {
    public InvalidAnimalDataException(String message) {
        super(message);
    }
}
