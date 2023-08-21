import java.util.List;

public class Position {

    List<Float> coordinates;

    public Position() {

    }

    public Position(List<Float> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Float> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Float> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Position{" +
                "coordinates=" + coordinates +
                '}';
    }
}
