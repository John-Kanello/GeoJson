package exception;

public class InvalidCoordinatesException extends RuntimeException {

    public InvalidCoordinatesException() {
      super("Coordinates cannot be null or empty");
    }
}
