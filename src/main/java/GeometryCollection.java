import java.util.ArrayList;
import java.util.List;

public class GeometryCollection extends GeoJson {

    private List<GeometryObject> geometries;

    public GeometryCollection() {
        super("GeometryCollection");
    }

    public GeometryCollection(List<GeometryObject> geometries) {
        super("GeometryCollection");
        this.geometries = geometries;
    }

    public List<GeometryObject> getGeometries() {
        return geometries;
    }

    public void setGeometries(List<GeometryObject> geometries) {
        this.geometries = geometries;
    }

    @Override
    public String toString() {
        return "GeometryCollection{" +
                "geometries=" + geometries +
                ", type='" + type + '\'' +
                '}';
    }
}
