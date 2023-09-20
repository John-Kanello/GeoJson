package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import geoJson.exceptions.InvalidBboxException;
import geoJson.exceptions.InvalidCoordinatesException;
import geoJson.util.BboxValidator;

import java.util.List;

@JsonTypeName("geoJson.MultiPoint")
public class MultiPoint extends GeometryObject<List<List<Float>>> {

    public MultiPoint() {
        super("geoJson.MultiPoint");
    }

    public MultiPoint(List<List<Float>> coordinates) {
        super("geoJson.MultiPoint", coordinates);
    }

    @Override
    public List<List<Float>> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<List<Float>> coordinates) {
        if (coordinates == null || coordinates.isEmpty()) {
            throw new InvalidCoordinatesException();
        } else if (!BboxValidator.isValid(this)) {
            throw new InvalidBboxException();
        }

        super.setCoordinates(coordinates);
    }

    @Override
    public String toString() {
        return "geoJson.MultiPoint{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}