import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.InvalidLinearRingException;
import utils.impl.PolygonManager;

import java.util.List;

@JsonTypeName("Polygon")
public class Polygon extends GeometryObject<List<List<List<Float>>>> {

    public Polygon() {
        super("Polygon");
    }

    public Polygon(List<List<List<Float>>> coordinates) {
        super("Polygon", coordinates);
        PolygonManager polygonManager = new PolygonManager();
        if(!polygonManager.isValid(coordinates)) {
            throw new InvalidLinearRingException();
        }

    }

    @Override
    public List<List<List<Float>>> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<List<List<Float>>> coordinates) {

        PolygonManager polygonManager = new PolygonManager();
        if(!polygonManager.isValid(coordinates)) {
            throw new InvalidLinearRingException();
        }
        super.setCoordinates(coordinates);
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                '}';
    }
}
