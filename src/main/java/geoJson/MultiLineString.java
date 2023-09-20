package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import geoJson.exceptions.InvalidBboxException;
import geoJson.exceptions.InvalidCoordinatesException;
import geoJson.util.BboxValidator;

import java.util.List;

@JsonTypeName("geoJson.MultiLineString")
public class MultiLineString extends GeometryObject<List<List<List<Float>>>> {

    public MultiLineString() {
        super("geoJson.MultiLineString");
    }

    public MultiLineString(List<List<List<Float>>> coordinates) {
        super("geoJson.MultiLineString", coordinates);
    }

    @Override
    public List<List<List<Float>>> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<List<List<Float>>> coordinates) {
        if (coordinates == null || coordinates.isEmpty()) {
            throw new InvalidCoordinatesException();
        } else if (!BboxValidator.isValid(this)) {
            throw new InvalidBboxException();
        }

        super.setCoordinates(coordinates);
    }

    @Override
    public String toString() {
        return "geoJson.MultiLineString{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}