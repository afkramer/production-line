package de.vw.fak73.productionline.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException() {
        this("Requested object not found.");
    }
}
