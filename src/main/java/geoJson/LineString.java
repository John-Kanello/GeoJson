package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import geoJson.exceptions.InvalidBboxException;
import geoJson.exceptions.InvalidCoordinatesException;
import geoJson.util.BboxValidator;

import java.util.List;

@JsonTypeName("LineString")
public class LineString extends GeometryObject<List<List<Float>>> {

    public LineString() {
        super("LineString");
    }

    public LineString(String type) {
        super(type);
    }

    public LineString(List<List<Float>> coordinates) {
        super("LineString", coordinates);
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
        return "LineString{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}