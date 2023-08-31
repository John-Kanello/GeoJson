package geoJson;

import exception.InvalidBboxException;
import exception.InvalidCoordinatesException;
import utils.impl.BboxManager;

import java.util.List;

public class GeometryCollection extends GeoJson {

    private List<GeometryObject> geometries;

    public GeometryCollection() {
        super("GeometryCollection");
    }

    public GeometryCollection(List<GeometryObject> geometries) {
        super("geoJson.GeometryCollection");
        this.geometries = geometries;
    }

    public List<GeometryObject> getGeometries() {
        return geometries;
    }

    public void setGeometries(List<GeometryObject> geometries) {
        if(!new BboxManager().isValid(this)) {
            throw new InvalidBboxException();
        }
        this.geometries = geometries;
    }

    @Override
    public String toString() {
        return "GeometryCollection{" +
                "geometries=" + geometries +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}
