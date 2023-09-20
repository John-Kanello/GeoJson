package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import geoJson.exceptions.InvalidBboxException;
import geoJson.exceptions.InvalidCoordinatesException;
import geoJson.exceptions.InvalidLinearRingException;
import geoJson.util.BboxValidator;
import geoJson.util.PolygonValidator;

import java.util.List;

@JsonTypeName("geoJson.Polygon")
public class Polygon extends GeometryObject<List<List<List<Float>>>> {

    public Polygon() {
        super("geoJson.Polygon");
    }

    public Polygon(List<List<List<Float>>> coordinates) {
        super("geoJson.Polygon", coordinates);
        if (!PolygonValidator.isValid(this)) {
            throw new InvalidLinearRingException();
        }
    }

    @Override
    public List<List<List<Float>>> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<List<List<Float>>> coordinates) {
        if (coordinates == null || coordinates.isEmpty()) {
            throw new InvalidCoordinatesException();
        }
        if(PolygonValidator.isValid(this)) {
            throw new InvalidLinearRingException();
        }
        if (!BboxValidator.isValid(this)) {
            throw new InvalidBboxException();
        }
        super.setCoordinates(coordinates);
    }

    @Override
    public String toString() {
        return "geoJson.Polygon{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}