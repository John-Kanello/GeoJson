import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.InvalidLinearRingException;

import java.util.List;

@JsonTypeName("Polygon")
public class Polygon extends GeometryObject<List<List<List<Float>>>> {

    public Polygon() {
        super("Polygon");
    }

    public Polygon(List<List<List<Float>>> coordinates) {
        super("Polygon", coordinates);
        if(coordinates == null || coordinates.size() < 4 || coordinates.get(0) != coordinates.get(coordinates.size() - 1)) {
            throw new InvalidLinearRingException("Linear Ring length must be larger than or equal to 4");
        }
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                '}';
    }
}
