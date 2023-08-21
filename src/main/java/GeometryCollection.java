import java.util.ArrayList;
import java.util.List;

public class GeometryCollection extends GeometryObject<List<GeometryObject>>{

    public GeometryCollection() {

    }

    public GeometryCollection(List<GeometryObject> coordinates) {
        super(coordinates, "GeometryCollection");
    }

    @Override
    public String toString() {
        return "\"GeometryCollection[" +
                "coordinates=" + getCoordinates() +
                ", type=" + type +
                "]";
    }

    @Override
    public List<GeometryObject> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<GeometryObject> coordinates) {
        super.setCoordinates(coordinates);
    }
}
