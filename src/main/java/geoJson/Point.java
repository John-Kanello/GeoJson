package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import geoJson.exceptions.InvalidBboxException;
import geoJson.exceptions.InvalidCoordinatesException;
import geoJson.util.BboxValidator;

import java.util.List;

@JsonTypeName("geoJson.Point")
public class Point extends GeometryObject<List<Float>> {

    public Point() {
        super("geoJson.Point");
    }

    public Point(List<Float> coordinates) {
        super("geoJson.Point");
        this.setCoordinates(coordinates);
    }

    @Override
    public List<Float> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<Float> coordinates) {
        if (coordinates == null || coordinates.isEmpty()) {
            throw new InvalidCoordinatesException();
        }
        if (!BboxValidator.isValid(this)) {
            throw new InvalidBboxException();
        }
        super.setCoordinates(coordinates);
    }

    @Override
    public String toString() {
        return "geoJson.Point{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}