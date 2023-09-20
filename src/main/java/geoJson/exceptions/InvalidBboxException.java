package geoJson.exceptions;


public class InvalidBboxException extends RuntimeException {

    public InvalidBboxException() {
        super("Bounding box length must be 2*n where n is the number of dimensions represented in the contained geometries");
    }
}