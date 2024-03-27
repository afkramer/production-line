package de.vw.fak73.productionline.exceptions;

public class CannotSaveObjectException extends RuntimeException {
    public CannotSaveObjectException(String message) {
        super(message);
    }

    public CannotSaveObjectException() {
        this("Cannot save the requested object.");
    }

}
