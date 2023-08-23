import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("Polygon")
public class Polygon extends GeometryObject<List<List<List<Float>>>> {

    public Polygon() {
        super("Polygon");
    }

    public Polygon(List<List<List<Float>>> coordinates) {
        super("Polygon", coordinates);

    }

    @Override
    public String toString() {
        return "Polygon{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                '}';
    }
}
