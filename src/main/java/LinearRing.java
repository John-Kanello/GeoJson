import exception.InvalidLinearRingException;

import java.util.List;

public class LinearRing extends LineString {

    public LinearRing(List<Position> coordinates) {
        super(coordinates);
        if(coordinates == null || coordinates.size() < 4 || coordinates.get(0) != coordinates.get(coordinates.size() - 1)) {
            throw new InvalidLinearRingException("Linear Ring length must be larger than or equal to 4");
        }

        setCoordinates(coordinates);
    }

    @Override
    public String toString() {
        return "LinearRing{" +
                "coordinates=" + getCoordinates() +
                ", type=" + type +
                '}';
    }
}