package exception;

public class InvalidLinearRingException extends RuntimeException {

    public InvalidLinearRingException() {
      super("Linear Ring length must be larger than or equal to 4");
    }
}
