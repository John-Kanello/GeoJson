package geoJson.exceptions;

public class InvalidLinearRingException extends RuntimeException {

    public InvalidLinearRingException() {
        super("Linear Ring length must be larger than or equal to 4 and first element must be the same as last element");
    }
}