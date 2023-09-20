package geoJson;

import com.fasterxml.jackson.databind.JsonSerializer;
import geoJson.exceptions.InvalidBboxException;
import geoJson.util.BboxValidator;


import java.util.List;

public class GeometryCollection extends GeoJson {

    private List<GeometryObject<?>> geometries;
    private JsonSerializer serializer;

    public GeometryCollection() {
        super("geoJson.GeometryCollection");
    }

    public GeometryCollection(List<GeometryObject<?>> geometries) {
        super("geoJson.GeometryCollection");
        this.geometries = geometries;
    }

    public List<GeometryObject<?>> getGeometries() {
        return geometries;
    }

    public void setGeometries(List<GeometryObject<?>> geometries) {
        if (!BboxValidator.isValid(this)) {
            throw new InvalidBboxException();
        }
        this.geometries = geometries;
    }

    @Override
    public String toString() {
        return "geoJson.GeometryCollection{" +
                "geometries=" + geometries +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}